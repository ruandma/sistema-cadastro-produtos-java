# Sistema de Cadastro de Produtos em Java

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos.

## Funcionalidades
- ✅ Cadastrar produto (código, nome, categoria, preço, estoque)
- ✅ Listar todos os produtos
- ✅ Buscar por código, nome ou categoria
- ✅ Atualizar produto
- ✅ Excluir produto
- 💾 Persistência em arquivo (`produtos.txt`)

## Como executar (Windows - PowerShell)

### Pré-requisitos:
- JDK 8 ou superior instalado (recomendado: [Eclipse Temurin JDK 8](https://adoptium.net/temurin/releases/?version=8))

### Passo a passo:

1. Abra o **PowerShell** na pasta raiz do projeto (onde está o `src`).
2. Limpe e crie a pasta `bin`:
   ```powershell
   Remove-Item -Recurse -Force bin -ErrorAction Ignore
   mkdir bin
3. Compile os arquivos (usando UTF-8):
   javac -d bin -encoding UTF-8 src\*.java
4. Execute o programa:
   java -cp bin Main

#### Aluno:
- Ruan de Morais Arruda

#### Observações:
- Os dados são salvos automaticamente no arquivo produtos.txt.
- O sistema é executado via linha de comando (console).
- Para usar acentos corretamente, salve os arquivos .java em UTF-8 (sem BOM).

##### 🛠️ Dica extra: crie um script `.bat` para facilitar

Crie um arquivo chamado `rodar.bat` na raiz do projeto com este conteúdo:

```bat
@echo off
echo Compilando...
javac -d bin -encoding UTF-8 src\*.java

if %errorlevel% neq 0 (
    echo Erro na compilação!
    pause
    exit /b 1
)

echo Executando...
java -cp bin Main

pause


Agora, basta dar dois cliques no rodar.bat — ele compila e executa tudo sozinho!