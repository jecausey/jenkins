apiVersion: v1
kind: Pod
metadata:
  labels:
    run: tf
  name: tf
spec:
  containers:
  - image: hashicorp/terraform
    name: tf
    command: ["sleep" , "2000"]

