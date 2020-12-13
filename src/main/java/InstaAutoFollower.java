import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InstaAutoFollower {

    public static Robot r1;
    public static ArrayList<String> nombresDeUsuarios;
    public static WebDriver driver;
    static int Desde;
    static int Hasta;


    public static String url = "https://www.instagram.com/";


    public static void main(String[] args) throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {


     //   PresionarBtnSeguidores();


     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

        AbrirDatos(System.getProperty("user.dir") + "\\datosDeUsuarios");

        IniciarDriver();

        Thread.sleep(1000);

    }

    private static int AbrirUltimoIndice(int dato) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int Indice = 0;

        try {

            archivo = new File(System.getProperty("user.dir") + "indice" + dato + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                Indice = Integer.parseInt(linea);
            }


        } catch (Exception s) {
            System.out.println("error");
        }
        System.out.println("ultimo indice grabado fue: " + Indice);

        return Indice;
    }

    private static void GuardarIndice(int hasta, int indice) {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(System.getProperty("user.dir") + "\\indice" + indice + ".txt");
            pw = new PrintWriter(fichero);
            pw.println(hasta);

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("se grabó indice " + indice);
    }

    private static String BuscarUsuario(int i) {
        System.out.println(nombresDeUsuarios.get(i));
        return nombresDeUsuarios.get(i);
    }


    private static void AgregarInsta(int desde, int hasta) {

        for (int us = desde; us < hasta; us++) {

            if (!nombresDeUsuarios.get(us).equals(null)) {
                try {
                    driver.get("https://www.instagram.com/" + nombresDeUsuarios.get(us));
                    driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
                    Thread.sleep(Math.abs(4000 - new Random().nextInt(1500)));
                    driver.findElement(By.xpath("//button[text()='Seguir']")).click();
                    System.out.println("cuenta va en " + us);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("No se encontró el boton seguir");
                    // System.exit(0);
                    System.out.println("quedo en el indice " + us);


                }
            }
        }
        // System.exit(0);

        //   driver.quit();

    }

    private static void AbrirDatos(String namefile) {

        nombresDeUsuarios = new ArrayList<String>();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(namefile + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                nombresDeUsuarios.add(linea);
                //   System.out.println(linea);
            }


        } catch (Exception s) {
            System.out.println("error");
        }


    }

    static void IniciarDriver() {


        driver = new ChromeDriver();
        // WebDriver driver = new HtmlUnitDriver();

        driver.get(url);

        driver.manage().addCookie(new Cookie("urlgen", "xxxxx"));
        driver.manage().addCookie(new Cookie("rur", "xxxxx"));
        driver.manage().addCookie(new Cookie("csrftoken", "xxxxxxxxxxxxxxxxxxxx"));
        driver.manage().addCookie(new Cookie("mid", "xxxxxxxxxxxxxxx"));
        driver.manage().addCookie(new Cookie("sessionid", "xxxxxxxxxxxxxxxxxxxxxxxxx"));
        driver.manage().addCookie(new Cookie("ds_user_id", "xxxxx"));
        driver.manage().addCookie(new Cookie("ig_did", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"));

        Desde = AbrirUltimoIndice(1);
        Hasta = Desde + 13;
        GuardarIndice(Hasta, 1);
        AgregarInsta(Desde, Hasta);


        driver.close();

    }




    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText =
                (contents != null) &&
                        contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



    private static void PresionarBtnSeguidores() throws InterruptedException, AWTException {

        r1 = new Robot();
        //presiona boton de seguidores:
        int x = 700;
        int y = 250;

        r1.mouseMove(x, y);

        r1.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(200);
                    r1.mouseMove(530, y + 2);
            r1.mouseMove(745, 444);


            for (int i = 250; i < 715; i++) {
                r1.mouseMove(x, i);
                Thread.sleep(30);
                i += 30;

            }

            for (int j = 0; j < 10; j++) {

                Thread.sleep(1000);  //1000
            }

            for (int j = 0; j < 3; j++) {
                r1.mouseWheel(2);
                Thread.sleep(1000);
            }

        }


        private static void ArreglarDatos(String completeNamePilePath) {


            ArrayList Datos = new ArrayList<String>();
            String[] Valores = {".", "s"};

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {

                archivo = new File(completeNamePilePath + ".txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;

                while ((linea = br.readLine()) != null) {

                    try {
                        if (!linea.contains("Foto") && !linea.contains(" ") && !Arrays.asList().contains(linea) && !linea.substring(0, 1).equals(linea.substring(0, 1).toUpperCase()) && !Datos.contains(linea)) {
                            Datos.add(linea);
                            System.out.println(linea);
                        }
                    } catch (Exception s) {
                        //s.printStackTrace();
                        System.out.println("error");
                    }


                }
                System.out.println("Numero de datos totales: " + Datos.size());

        } catch (Exception s) {
            System.out.println("error");
        }

    }


}



