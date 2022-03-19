# InstaAutoFollowers

Instagram can be a great tool for introducing new products or services. For helping your own business or simply as a marketing business (+10k) instagram can be a great tool to earn some money. Here a tool you can use for it ¡

# Instruccions

1) make an instagram account and get the coockies of the session, then fill the coockies into the programs
2) get the chrome selenium driver from:

https://chromedriver.chromium.org/downloads

check with your chrome version and place it in the program directory
3) get an insta group and scann the followers with the script bellow.
4) that's all ;)


To get followers names you can use robot framwork and scann it directly from the screen, with this script (according to my screen size):

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

In order to filter instagram real names:

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


