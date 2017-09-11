# DesafioTecnico_LECOM


Desafio

Criar uma aplicação java web onde:

 

Como usuário da aplicação posso:

- Cadastrar os clientes da minha empresa
- Cadastrar os serviços  que minha empresa oferece
- Registrar que meu cliente contratou um serviço da minha empresa onde possa definir a data de início e de fim do serviço
- Visualizar quais serviços meu cliente tem contratado e quantos dias faltam para atingir a data final do serviço. 


Também gostaria de visualizar o valor  dos  serviços contratados por um cliente, onde:
- Clientes do tipo Ouro têm 10% de desconto
- Clientes do tipo Prata que têm 5% de desconto
- Se o pagamento for até 10  dias antes da data final, dar mais 5% de desconto no cálculo do valor (considerando a data atual)


Além disso gostaria de disponibilizar um serviço REST que retorne um JSON contendo os dados de todos os  serviços da minha empresa. Esse serviço poderá ser consumido por uma outra aplicação.


Requisitos técnicos:

- Backend em Java
- Deverá utilizar uma framework ORM para persistência dos dados
- Banco pode ser o MySQL
- Front-end deve ser feito React ou Vue.js

#OBS:
Para o funcionamento do mesmo, altere as informações referentes à conexão com o banco de dados.
O arquivo responsável pelas configurações "persistence.xml" é encontra no seguinte local:
	- "SRC/JAVA/META-INFO"

	<properties>
		<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
		<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/DATABASE" /> 
		<property name="javax.persistence.jdbc.user" value="USER" />
		<property name="javax.persistence.jdbc.password" value="PASSWORD" />
		<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect" />
		<property name="hibernate.hbm2ddl.auto" value="CREATE" />
		<property name="hibernate.show_sql" value="true" />
	</properties>