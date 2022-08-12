import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDeDados {
	
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;
		
		public void conectar () {
	
			String servidor = "jdbc:mysql://localhost/ibm";
			String usuario = "root";
			String senha = "mysql";
			String driver = "com.mysql.cj.jdbc.Driver";
			
			try {
				Class.forName(driver);
				this.connection=DriverManager.getConnection(servidor,usuario,senha);
				this.statement=this.connection.createStatement();

			} catch (Exception e) {
				System.out.println("Erro" + e.getMessage());
			}
			
		}
		
		public boolean estaConectado() {
			if(this.connection != null) {
				return true;
			} else {
				return false;
			}
		}
		
		//
		
		public void listaProdutos() {
			try {
				String consulta = "select * from produtos";
				this.resultset = this.statement.executeQuery(consulta);
				this.statement = this.connection.createStatement();
				while(this.resultset.next()) {
					String produtoID = resultset.getString("id_produto");
					String produtoNome = resultset.getString("nome_produto");
					System.out.println("Código de barras: " + produtoID);
					System.out.println("Produto: " + produtoNome);
				}
				} catch(Exception e) {
					System.out.println("Erro: "+ e.getMessage());
				}
			}

}


