
public class ExecutaSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		
		if(bd.estaConectado()) {
			
			bd.listaProdutos();

		} else {
			System.out.println("Conecção falha");
		}
	}

	}


