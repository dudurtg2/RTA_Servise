import json
import os
import requests

# URL para login
url = "http://localhost:8080/auth/login"

# Cabeçalhos para a requisição
headers = {
    "Content-Type": "application/json"
}

# Dados de autenticação
bases = {
    "login": "joao.silva@example.com",
    "senha": "senhaSegura123"
}

# Variável para o token
token: str

try:
    # Requisição de autenticação
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
        token = response.json()['token']
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)

# Lista de endpoints
getall = [
    "http://localhost:8080/api/empresas/findAll",
    "http://localhost:8080/api/funcionarios/findAll",
    "http://localhost:8080/api/motoristas/findAll",
    "http://localhost:8080/api/entregadores/findAll",
    "http://localhost:8080/api/romaneios/findAll",
    "http://localhost:8080/api/bases/findAll",
    "http://localhost:8080/api/cidades/findAll",
    "http://localhost:8080/api/regioes/findAll",
    "http://localhost:8080/api/codigos/findAll"
]

# Atualiza cabeçalhos com o token
headers = {
    "Authorization": f"Bearer {token}",
}

# Criação da pasta "dados"
# Obtém o caminho do diretório onde o script está localizado
base_dir = os.path.dirname(os.path.abspath(__file__))
output_dir = os.path.join(base_dir, "dados")

# Cria a pasta "dados" no mesmo local do script
os.makedirs(output_dir, exist_ok=True)

# Requisições aos endpoints
for url in getall:
    try:
        response = requests.get(url, headers=headers)
        if response.status_code == 200:
            filename = os.path.join(output_dir, url.split("/")[-2] + '.json')
            with open(filename, 'w', encoding='utf-8') as f:
                json.dump(response.json(), f, ensure_ascii=False, indent=4)
            print(f"Arquivo salvo: {filename}")
        else:
            print(f"Erro: {response.status_code} - {response.text}")

    except requests.exceptions.RequestException as e:
        print("Erro ao enviar a requisição:", e)
