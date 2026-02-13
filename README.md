docker pull postgres
docker run -p 5432:5432 -e POSTGRES_PASSWORD="{비밀번호}" --name {컨테이너명} postgres
