# Email Service

Este projeto é um serviço de email que utiliza o Amazon SES (Simple Email Service) para enviar emails, desenvolvido em Spring Java.

## Requisitos

- Java 21 ou superior
- Conta na AWS com permissões para usar o Amazon SES
- AWS SDK para Java

## Instalação

1. Clone o repositório:

2. Importe o projeto em sua IDE preferida (Eclipse, IntelliJ, etc.).

3. Configure suas credenciais da AWS:
    - No arquivo `application.properties` na pasta `src/main/resources` edite as seguintes variáveis:
        ```properties
        aws.accessKeyId=your_access_key_id
        aws.secretKey=your_secret_access_key
        aws.region=your_aws_region
        ```

## Uso

Execute o projeto

Depois, faça uma requisição POST para o endpoint `api/email` com o seguinte payload:

```json
{
    "to": "recipient@example.com",
    "subject": "Assunto do Email",
    "body": "Corpo do Email"
}
```

