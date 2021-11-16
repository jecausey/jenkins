resource "aws_s3_bucket" "tf-bucket" {
  bucket = "my-tf-bucket"
  acl    = "private"

  tags = {
    Name        = "TF bucket"
      }
}