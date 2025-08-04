Este repositório demonstra uma aplicação Android utilizando o Jetpack Compose, com integração do DataStore para persistência de dados, seguindo as boas práticas recomendadas pela documentação.
No projeto, o DataStore é utilizado para armazenar preferências do usuário. A implementação foi feita via classes dedicadas, como DataStoreManager, PreferencesManager e DataStoreHelper.

  - Utilizei a extensão do Context para inicializar o DataStore:
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "jetnews_prefs")

  - Para salvar informações, como preferências, utilizei funções suspensas:
    suspend fun saveExample(value: String) {
        context.dataStore.edit { preferences ->
            preferences[EXAMPLE_KEY] = value
        }
    }
  - Para recuperar os dados, utilizei o Flow para garantir atualização reativa nas telas da aplicação:
    fun getExample(): Flow<String> {
        return context.dataStore.data
            .map { preferences -> preferences[EXAMPLE_KEY] ?: "default" }
    }
  - O DataStore foi acessado via ViewModels, permitindo salvar e recuperar configurações do usuário de forma desacoplada e testável.

## Como executar

1. Clone o repositório:
2. Abra o projeto no Android Studio.
3. Execute a aplicação em um dispositivo ou emulador.

---
Desenvolvido por **Fatimaleh**
