# 🏪 Guia Pocket - BES

<div align="center">

![Kotlin](https://img.shields.io/badge/Kotlin-Android%20Studio-purple?style=for-the-badge&logo=kotlin)
![Android](https://img.shields.io/badge/Android-Mobile%20App-green?style=for-the-badge&logo=android)
![Room](https://img.shields.io/badge/Room-2.6.1-blue?style=for-the-badge&logo=android)

**Um aplicativo guia para descobrir serviços e comércios locais da cidade de Boa Esperança do Sul - SP**

</div>

## 📱 Sobre o Projeto

O **Guia Pocket - BES** é um aplicativo Android desenvolvido em Kotlin que tem como objetivo divulgar e conectar moradores com pequenos comércios e prestadores de serviços da região. O app permite visualizar estabelecimentos cadastrados, buscar por nome, adicionar novos locais com fotos da galeria e fazer ligações diretamente do aplicativo.

Este projeto é a **segunda versão** do aplicativo, focada em **performance, persistência de dados e funcionalidade de cadastro**.

---

## ✨ Funcionalidades

### 📋 Lista de Serviços
- Visualização eficiente com **RecyclerView**
- Cada item exibe: **imagem**, **nome** e **categoria**
- Layout personalizado para cada estabelecimento

### 🔍 Busca em Tempo Real
- **EditText** na tela principal para filtrar estabelecimentos
- Busca por nome instantânea enquanto você digita
- Interface responsiva e fluida

### ➕ Cadastro de Novos Estabelecimentos
- Formulário completo para adicionar novos locais
- **Seleção de imagem da galeria** do dispositivo
- Campos: nome, categoria, descrição e telefone
- Uso de **ActivityResultLauncher** para retorno de dados

### 💾 Persistência de Dados
- **Room Database** para armazenamento local permanente
- Dados persistem mesmo após fechar o aplicativo
- Imagens armazenadas via **URI persistente**
- Arquitetura em camadas: Entity, DAO, Database e Repository

### 📞 Integração Nativa
- **Intent ACTION_DIAL** para fazer ligações
- Detalhes completos do estabelecimento em tela dedicada

### 🌐 Internacionalização
- Suporte a **Português** e **Inglês**
- Interface adaptável ao idioma do sistema

---

## 🛠️ Tecnologias e Conceitos

### Linguagem e Framework
- **Kotlin** - Linguagem principal
- **Android SDK** - Plataforma de desenvolvimento
- **ViewBinding** - Acesso type-safe às views

### Componentes Android
- **RecyclerView** - Lista eficiente e otimizada
- **ConstraintLayout** - Layouts responsivos
- **Intents Explícitas** - Navegação entre Activities
- **Intents Implícitas** - Ação de ligação telefônica
- **ActivityResultLauncher** - Retorno de dados entre Activities

### Persistência de Dados
- **Room 2.6.1** - Abstração sobre SQLite
  - `@Entity` - Definição de tabelas
  - `@Dao` - Operações CRUD
  - `@Database` - Configuração do banco
- **Repository Pattern** - Camada de abstração de dados

### Arquitetura
```
📦 app
 ┣ 📂 ui              # Activities (MainActivity, CadastroActivity, DetalheActivity)
 ┣ 📂 model           # Entidades (Estabelecimento)
 ┣ 📂 data            # DAO, Database, Repository
 ┣ 📂 adapter         # EstabelecimentoAdapter (RecyclerView)
 ┗ 📂 res             # Recursos (layouts, drawables, strings)
```

### Boas Práticas
- ✅ Organização por pacotes (ui, model, data, adapter)
- ✅ ViewBinding em todas as telas
- ✅ Padrão Singleton para Database
- ✅ Separação de responsabilidades (SRP)
- ✅ Nomes semânticos e código limpo
- ✅ ConstraintLayout para performance

---

## 🎥 Demonstrações em Vídeo

### 📹 Vídeo Curto (30 segundos)
> Demonstração rápida do funcionamento geral do aplicativo

🔗 **[Assistir Vídeo Curto](https://youtube.com/shorts/BW2xTVWq0tw)**

### 🎬 Vídeo Explicativo Completo (5-10 minutos)
> Explicação detalhada do código: Intents, RecyclerView, Adapter, ActivityResult, Filtro, Room e arquitetura

🔗 **[Assistir Vídeo Completo](https://youtu.be/YppndRMhmdE)**

---

## 📸 Capturas de Tela

### 🏠 Tela Principal com RecyclerView

| Lista de Estabelecimentos | Busca/Filtro em Tempo Real |
|---------------------------|----------------------------|
| <img src="Mídias Guia Pocket/tela_principal_v2.png" width="300"> | <img src="Mídias Guia Pocket/tela_filtro.png" width="300"> |

### ➕ Tela de Cadastro

| Formulário de Cadastro | Seleção de Imagem |
|------------------------|-------------------|
| <img src="Mídias Guia Pocket/tela_cadastro.png" width="300"> | <img src="Mídias Guia Pocket/tela_cadastro_imagem.png" width="300"> |

### 📋 Tela de Detalhes

| Detalhes do Estabelecimento |
|-----------------------------|
| <img src="Mídias Guia Pocket/tela_detalhes_v2.png" width="300"> |

---

## 🚀 Como Executar

### Pré-requisitos
- **Android Studio** (versão Hedgehog ou superior)
- **JDK 11** ou superior
- Dispositivo Android ou Emulador com **API 33+** (Android 13+)

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SilvioLSS/Guia-Pocket-BES.git
   ```

2. **Abra no Android Studio:**
   - `File` → `Open` → Selecione a pasta do projeto

3. **Sincronize o Gradle:**
   - `File` → `Sync Project with Gradle Files`

4. **Execute o app:**
   - Conecte um dispositivo Android **OU** inicie um emulador
   - Clique em **"Run"** ▶️ (Shift + F10)

5. **Teste as funcionalidades:**
   - Adicione novos estabelecimentos
   - Busque por nome
   - Visualize detalhes
   - Faça ligações

---

## 📚 Estrutura do Código

### Principais Classes

#### 📱 UI Layer
- **MainActivity.kt** - Tela principal com RecyclerView e filtro
- **CadastroEstabelecimentoActivity.kt** - Formulário de cadastro
- **DetalheEstabelecimentoActivity.kt** - Detalhes do estabelecimento

#### 🎨 Adapter
- **EstabelecimentoAdapter.kt** - Adapter da RecyclerView com ViewHolder

#### 💾 Data Layer
- **Estabelecimento.kt** - Entity do Room
- **EstabelecimentoDao.kt** - Interface com operações CRUD
- **AppDatabase.kt** - Configuração do Room Database (Singleton)
- **EstabelecimentoRepository.kt** - Abstração de acesso aos dados

---

## 🔑 Destaques Técnicos

### Room Database
```kotlin
@Entity(tableName = "estabelecimentos")
data class Estabelecimento(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val foto: Int = 0,
    val fotoUri: String? = null,
    val nome: String,
    val categoria: String,
    val descricao: String,
    val telefone: String
) : Serializable
```

### ActivityResultLauncher (Cadastro)
```kotlin
launcherCadastro = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
        carregarEstabelecimentos()
    }
}
```

### Filtro em Tempo Real
```kotlin
binding.edtFiltro.addTextChangedListener(object : TextWatcher {
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        filtrarEstabelecimentos(s.toString())
    }
})
```

---

## 📊 Evolução do Projeto

### Versão 1.0 (Primeiro Bimestre)
- ✅ ListView com dados estáticos
- ✅ Navegação com Intents
- ✅ Internacionalização
- ✅ Modo claro/escuro

### Versão 2.0 (Segundo Bimestre) - **ATUAL**
- ✅ RecyclerView para melhor performance
- ✅ Room Database para persistência
- ✅ Cadastro de novos estabelecimentos
- ✅ Seleção de imagens da galeria
- ✅ Filtro em tempo real
- ✅ ActivityResultLauncher
- ✅ ConstraintLayout em todas as telas
- ✅ Arquitetura em camadas (Repository Pattern)

---

## 👨‍💻 Desenvolvedor

**Silvio Luiz Silva Santos**

- 🎓 IFSP - Campus Araraquara
- 📚 Análise e Desenvolvimento de Sistemas
- 📧 silvioluiz.dev@gmail.com
- 💼 [LinkedIn](https://www.linkedin.com/in/silviolss/)
  
---

## 📄 Licença e Contexto Acadêmico

Este projeto foi desenvolvido para fins educacionais como parte da disciplina:

**ARQDMO1 - Dispositivos Móveis 1**  
**Professor:** Henrique Galati  
**Instituição:** IFSP - Campus Araraquara  
**Período:** 2º Bimestre de 2024

---

## 🙏 Agradecimentos

- Prof. Henrique Galati pela orientação
- Comunidade Android Developer para documentação
- Colegas de turma pelo feedback

---

<div align="center">

**⭐ Se este projeto foi útil, considere dar uma estrela no repositório!**

Desenvolvido com ❤️ por [Silvio Luiz Silva Santos](https://github.com/SilvioLSS)

</div>
