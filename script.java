package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class HelloMIDlet extends MIDlet implements CommandListener {

    private Command exitCommand,exitCommand1,exitCommand2,process,back1,back2,back3,add; // The exit command
    private Display display;     // The display for this MIDlet
    private Form mform,mform1,mform2,mform3;
    TextField t1,t2,t3,t4,t5,t6,t7;
    String [] s1 ={"Newspaper","book"};
    ChoiceGroup c1;
    public HelloMIDlet() {

        mform= new Form("Welcome to j2me \n Date and Time");

        exitCommand = new Command("EXIT", Command.EXIT, 0);
        process = new Command("PROCESS",Command.SCREEN,0);

        t1 = new TextField("Name", "Name", 256, 0);
        t2 = new TextField("DOB","DOB",236,0);

        c1= new ChoiceGroup("Select",ChoiceGroup.EXCLUSIVE,s1,null);
        c1.setSelectedIndex(0, true);

        mform.append(t1);
        mform.append(t2);
        mform.append(c1);

        mform.addCommand(process);
        mform.addCommand(exitCommand);

        mform.setCommandListener(this);
    }

    public void startApp() {

         display = Display.getDisplay(this);
         display.setCurrent(mform);
  }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
       
        if(s == mform){
             if (c == exitCommand) {
            destroyApp(true);
            notifyDestroyed();
        }
            if(c == process){

                String n=t1.getString();
                String d=t2.getString();
                int i=c1.getSelectedIndex();
                if(i==0){
                    mform1= new Form("Newpaper");

                    String s2 = "Welcome "+n+"\n";
                    String s3[]={"1.The Hindu\n","2.Times Of India\n","3.NavBharat Times\n"};

                    mform1.append(s2);
                    mform1.append(s3[0]);
                    mform1.append(s3[1]);
                    mform1.append(s3[2]);

                    exitCommand1 = new Command("EXIT", Command.EXIT, 0);
                    back1 = new Command("BACK",Command.SCREEN,0);

                    mform1.addCommand(back1);
                    mform1.addCommand(exitCommand1);

                    mform1.setCommandListener(this);

                    display.setCurrent(mform1);
                }
                if(i==1){

                    mform2= new Form("Enter book details");

                    String l = "Welcome "+n+"\n";

                    t3 = new TextField("Book Id", "Book Id", 256, 0);
                    t4 = new TextField("Name","Name",236,0);
                    t5 = new TextField("Author", "Author", 216, 0);
                    t6 = new TextField("Edition","Edition",196,0);
                    t7 = new TextField("Year","Year",176,0);

                    mform2.append(l);
                    mform2.append(t3);
                    mform2.append(t4);
                    mform2.append(t5);
                    mform2.append(t6);
                    mform2.append(t7);

                    add = new Command("ADD", Command.SCREEN, 0);
                    back2 = new Command("BACK",Command.SCREEN,0);

                    mform2.addCommand(back2);
                    mform2.addCommand(add);

                    mform2.setCommandListener(this);

                    display.setCurrent(mform2);

                 }
        }
        }
        else if(s == mform1){
             if (c == exitCommand1) {
            destroyApp(true);
            notifyDestroyed();
        }
             if(c==back1){

                display.setCurrent(mform);
            }
        }
        else if(s == mform2){
            String id=t3.getString();
            String n=t4.getString();
            String a=t5.getString();
            if(c== add){
                int flag=1;
                int len= id.length();
                if(len==7){
                    for(int i=0;i<id.length();i++)
                {
                    char c1=id.charAt(i);
                    if(i==4||i==5||i==6)
                    {
                        if(!((c1>=65&& c1<=90)||(c1>=97&&c1<=122)))
                        {
                            flag=0;
                        }

                    }
                    else if(i==3)
                    {
                        if(!(c1=='.'))
                        {
                            flag=0;
                        }

                    }
                    else if(i==0||i==1||i==2)
                    {
                        if(!Character.isDigit(c1))
                        {
                            flag=0;
                        }
                    }
                }
                }
                else{
                    flag=0;
                }
                String dip="";
                if(flag==1){
                dip="Book "+n+" with author "+a+" added";
                }
                else if(flag==0){
                dip="Id not valid ";
                }
                mform3= new Form("Book added");
                mform3.append(dip);
                exitCommand2 = new Command("EXIT", Command.EXIT, 0);
                back3 = new Command("BACK",Command.SCREEN,0);

                mform3.addCommand(back3);
                mform3.addCommand(exitCommand2);

                mform3.setCommandListener(this);

                display.setCurrent(mform3);
                }
                
            
            if(c==back2){

                display.setCurrent(mform);
            }
        }
        else if(s==mform3){
             if (c == exitCommand2) {
            destroyApp(true);
            notifyDestroyed();
        }
            if(c==back3){

                display.setCurrent(mform2);
            }
        }

}

    }

