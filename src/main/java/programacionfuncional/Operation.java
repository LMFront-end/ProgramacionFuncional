package programacionfuncional;

public interface Operation {

    private void interfacePrivateMethod(){
        System.out.println("LLmando al método privado de una interfaz");
        interfacePrivateMethod();
    }

    static void interfaceStaticMethod(){
        System.out.println("Llamado al método estático de una interfaz");
    }

    default void interfaceDefaultMethod(){
        interfacePrivateMethod();
        interfaceStaticMethod();
        System.out.println("Llamado al método default de una interfaz");
    }
}
