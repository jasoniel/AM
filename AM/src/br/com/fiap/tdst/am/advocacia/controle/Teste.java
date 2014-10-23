package br.com.fiap.tdst.am.advocacia.controle;

class Teste{
	

	public static void main(String [] args){

			

			int [] vetor ={6,9,8,1,2,11,3};
			int temp=0;


			//selection

			for(int i = 0 ; i< vetor.length;i++){


				for(int j = i+1 ; j<(vetor.length-1);i++){
					

					if(vetor[i]>vetor[j+1]){
						temp=vetor[j+1];
						vetor[j+1]=vetor[j];
						vetor[j]=temp;

					}

				}	

			}
			
			for(int i = 0; i<vetor.length; i++){


				System.out.print(vetor[i]+",");
	
			}
		

	}

}