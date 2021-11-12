
podTemplate(containers: [
    containerTemplate(
        name: 'terraform', 
        image: 'hashicorp/terraform'
        )
  ]) {

    node(POD_LABEL) {
        stage('Get TF from Repo') {
            container('terraform') {
                stage('Shell Execution') {
                    sh '''
                    git clone "
                    '''
                }
            }
        }

    }
}
