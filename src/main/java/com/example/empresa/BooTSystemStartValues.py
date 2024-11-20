import requests
url = "http://localhost:30514/bases/save"

token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImR1ZGkiLCJleHAiOjE3MzIyNDU5MDl9.41n8mqM2hZ0CL-oOIL91GKXus_aP5C0Seof1GSLHW2Q"


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


url = "http://localhost:30514/motoristas/save"


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



url = "http://localhost:30514/regioes/save"


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




url = "http://localhost:30514/cidades/save"


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




url = "http://localhost:30514/empresas/save"


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




url = "http://localhost:30514/motoristas/save"


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


url = "http://localhost:30514/funcionarios/save"


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


url = "http://localhost:30514/motoristas/save"


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


url = "http://localhost:30514/entregadores/save"


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


url = "http://localhost:30514/romaneios/save"


headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}


romaneios = {
    "empresa": { "id": 1 },
    "motorista": { "id": 1},
    "entregador": { "id": 1},
    "funcionario": { "id": 1},
    "base": { "id": 1 },
    "cidade": { "id": 1 },
    "sts": "sts",
    "quantidade": 1,
    "codigoUid": "codigo_uid",
    "linkDownload": "link_download",
    "data": "data",
    "dataFinal": "data_final",
    "ocorrencia": "ocorrencia",
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
