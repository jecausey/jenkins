podTemplate(containers: [
    containerTemplate(
        name: 'terraform', 
        image: 'hashicorp/terraform',
        command: 'sleep' ,
        args: '30d'
        )
  ]) {

    node(POD_LABEL) {
        stage('Get TF') {
            container('terraform') {
                stage('Shell Execution') {
                    sh git clone https://github.com/jecausey/ec2.git /tmp/git/
                }
            }
        }
        stage('TF init') {
            container('terraform') {
                stage('Shell Execution') {
                    sh "cd /tmp/git ; terraform init"
                }
            }
        }
        stage('TF plan') {
            container('terraform') {
                stage('Shell Execution') {
                    sh "cd /tmp/git ; terraform plan -out=tfplan"
                }
            }
        }
        stage('TF apply') {
            container('terraform') {
                stage('Shell Execution') {
                    sh "cd /tmp/git ; terraform apply -auto-approve"
                }
            }
        }
    }
}