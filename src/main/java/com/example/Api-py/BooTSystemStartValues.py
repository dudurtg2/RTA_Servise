import requests
url = "http://localhost:30514/auth/register"

headers = {
    "Content-Type": "application/json"
}


bases = {
    "login": "dudu",
    "senha": "dudu",
    "role": "ADMIN"
}


try:
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())

    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:30514/auth/login"

headers = {
    "Content-Type": "application/json"
}


bases = {
    "login": "dudu",
    "senha": "dudu"
}

token : str

try:
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
        token = response.json()['token']
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:30514/api/bases/save"



headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


bases = {
    "nome": "Base 1",
    "endereco": "Rua 1, 123"
}


try:
    response = requests.post(url, json=bases, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:30514/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Motorista 1",
    "email": "2M0ZI@example.com",
    "cpf": "123.456.789-10",
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



url = "http://localhost:30514/api/regioes/save"


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




url = "http://localhost:30514/api/cidades/save"


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




url = "http://localhost:30514/api/empresas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


empresas = {
    "nome": "Empresa 1",
    "cnpj": "123456789"
}


try:
    response = requests.post(url, json=empresas, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)




url = "http://localhost:30514/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Entregador 1",
    "email": "2M0ZI@example.com",
    "cpf": "123.456.789-00",
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


url = "http://localhost:30514/api/funcionarios/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


funcionarios = {
    "nome": "Funcionario 1",
    "email": "2M0ZI@example.com",
    "cpf": "123.456.789-00",
    "telefone": "123456789",
    "base": {"id": 1}
}


try:
    response = requests.post(url, json=funcionarios, headers=headers)
    if response.status_code == 200:
        print("Resposta:", response.json())
    else:
        print(f"Erro: {response.status_code} - {response.text}")

except requests.exceptions.RequestException as e:
    print("Erro ao enviar a requisição:", e)


url = "http://localhost:30514/api/motoristas/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


motoristas = {
    "nome": "Motorista 1",
    "email": "2M0ZI@example.com",
    "cpf": "123.456.789-00",
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


url = "http://localhost:30514/api/entregadores/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


entregadores = {
    "nome": "Entregador 1",
    "email": "2M0ZI@example.com",
    "cpf": "123.456.789-00",
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


url = "http://localhost:30514/api/romaneios/save"


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

url = "http://localhost:30514/api/romaneios/save"


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


