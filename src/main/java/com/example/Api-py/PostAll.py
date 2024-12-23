import json
import os
import requests

url = "http://carlo4664.c44.integrator.host:10500/auth/login"

headers = {
    "Content-Type": "application/json"
}

bases = {
    "login":"carlos.e.o.savegnago@gmail.com",
    "senha":"DUdu@147"
}

token = ""

try:
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        token = response.json()['accessToken']
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)

url_cidades = "http://carlo4664.c44.integrator.host:10500/auth/register"

headers_cidades = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

with open('src/main/java/com/example/Api-py/ApiData/register.json', 'r', encoding='utf-8') as f:
    cidades_data = json.load(f)

for cidade in cidades_data:
    try:
        response = requests.post(url_cidades, json=cidade, headers=headers_cidades)
        if response.status_code == 201:
            print(f"Cidade '{cidade['nome']}' salva com sucesso:", response.json())
        else:
            print(f"Erro ao salvar a cidade '{cidade['nome']}': {response.status_code} - {response.text}")
    
    except requests.exceptions.RequestException as e:
        print(f"Erro ao enviar a cidade '{cidade['nome']}':", e)
