package eventVitals;



public class CommandVitals {
    /* all the command vitals for the /meme */
    public class slashPing {
        public static int getintfromstring(String stringint){
            int Toreturn = 0;
            try {
                Toreturn = Integer.parseInt(stringint);
            }finally {
                System.out.println("finished parse");
            }
            return Toreturn;
        }
    }
}

