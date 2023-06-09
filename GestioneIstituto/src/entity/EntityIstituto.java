package entity

import java.util.ArrayList;

public static class EntityIstituto{
    
  public static int creaDocente(String username,String password, String nome, String cognome, Date dataNascita, String email, String numeroCellulare, Array<String> materie ){
    int ret;
    EntityDocente docente=new EntityDocente(username);
    
    docente.setUsername(username);
    
    if(int i=0;i<materie.size();i++){
        ret=IstitutoDAO.verificamaterie(materie.get(i));
      
        if(ret != -1){
            docente.caricaMaterie(docente);
            ret= docente.scrivisuDB(username)
            
                return ret;
                
        }else{
            System.out.println("materie non valide!");
            return ret; 
        }
    }
    
  }
  
  public static int creaStudente(){
      
  }
  
  
  
  
}
