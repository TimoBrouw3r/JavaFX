package nl.saxion.re.types;

public enum UserTypes{
    ADVISOR("views/advisor.fxml"),
    PLANNER("views/planner.fxml"),
    INSTALLER("views/installer.fxml"),
    INVENTORY("views/inventory.fxml"); 

    private String file; 

    private UserTypes(String file){
        this.file = file;
    };

    public String getFile(){
        return file;
    }
}

