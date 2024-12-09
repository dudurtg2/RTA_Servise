import json
import os
import requests

url = "http://localhost:8080/auth/login"

headers = {
    "Content-Type": "application/json"
}

bases = {
    "login": "Teste@gmail.com",
    "senha": "123"
}

token : str

try:
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
        token = response.json()['accessToken']
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:8080/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Motorista 1",
    "email": "2M0ZI@example.com",
    "cpf": "215.691.440-01",
    "telefone": "123456789",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=motoristas, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)



url = "http://localhost:8080/api/regioes/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


Regiaos = {
    "nome": "Sul",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=Regiaos, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)




url = "http://localhost:8080/api/cidades/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


cidades = { 
    "nome": "Cidade 1",
    "cep": "12345678",
    "regiao": {
        "id": 1
    }
}


try:
    response = requests.post(url, json=cidades, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)




url = "http://localhost:8080/api/empresas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


empresas = {
    "nome": "Empresa 1",
    "cnpj": "07.603.527/0001-50"
}


try:
    response = requests.post(url, json=empresas, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)




url = "http://localhost:8080/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Entregador 1",
    "email": "2M0ZIsd@example.com",
    "cpf": "209.605.600-41",
    "telefone": "123456789",
    "endereco": "Rua 1, 123",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=motoristas, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)




url = "http://localhost:8080/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Motorista 1",
    "email": "2M0ZI2@example.com",
    "cpf": "393.960.940-48",
    "telefone": "123456789",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=motoristas, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:8080/api/entregadores/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


entregadores = {
    "nome": "Entregador 1",
    "email": "2M0ZI33@example.com",
    "cpf": "769.069.880-85",
    "telefone": "123456789",
    "endereco": "Rua 1, 123",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=entregadores, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:8080/api/romaneios/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

romaneios = {
    "empresa": 1,
    "entregador": 1,
    "funcionario": 1,
    "base": 1,
    "cidade": 1,
    "codigoUid": "codigo_uid",
    "linkDownload": "link_download",
    "codigos": [
        { "codigo": "codigo1" },
        { "codigo": "codigo2" },
        { "codigo": "codigo3" },
        { "codigo": "codigo4" }
    ]
}


try:
    response = requests.post(url, json=romaneios, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)

url = "http://localhost:8080/api/romaneios/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

romaneios = {
    "empresa": 1,
    "entregador": 1,
    "funcionario": 1,
    "base": 1,
    "cidade": 1,
    "codigoUid": "codigo_uid2",
    "linkDownload": "link_download2",
    "codigos": [
        { "codigo": "codigo12" },
        { "codigo": "codigo22" },
        { "codigo": "codigo23" },
        { "codigo": "codigo24" }
    ]
}


try:
    response = requests.post(url, json=romaneios, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


