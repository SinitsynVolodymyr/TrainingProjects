package com;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Nothing
 */
class App1 {
    public static void main(String[] args) throws Throwable {}
}

/**
 * Also nothing
 */
class App2 {
    public static void main(String[] args) {
        try {
        } catch (Throwable t) {}
    }
}

/**
 * Error
 */
class App3 {
    public static void main(String[] args) {
        throw new Error();
    }
}

/**
 * NullPointerException
 */
class App4 {
    public static void main(String[] args) {
        throw null;
    }
}

/**
 * StackOverflowError
 */
 class App5 {
    public static void main(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }
}

/**
 * sout - is not error
 */
 class App6 {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}


/**
 * sout - first
 */
 class App7 {
    public static void main(String[] args) {
        System.err.println("sout");
        throw new Error();
    }
}

// get double return double
 class App8 {
    public double sqr(double arg) {
        return arg * arg;
    }
}

// get double return double
 class App9 {
    public double sqr(double arg) {
        int k = 1;
        return k;
    }
}

// get double return double
 class App10 {
    public double sqr(double arg) {
        int k = 1;
        return (double) k;
    }
}

 class App11 {
    public static void main(String[] args) {
        double d = sqr(10.0);
        System.out.println(d);
    }
    public static double sqr(double arg) {
        // nothing
        return arg; //it's needed
    }
}

//forever
 class App12 {
    public static double sqr(double arg) {
        while (true);
    }
}

class App13 {
    public static void main(String[] args) {
        double d = sqr(10.0);
        System.out.println(d);
    }
    public static double sqr(double arg) {
        while (true); //forever
    }
}

 class App14 {
    public static double sqr(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg;
        } else {
            while (true);
        }
    }
}

 class App15 {
    public static double sqr(double arg) {
        throw new RuntimeException();
    }
}

 class App16 {
    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {
            while (true);                 // не, я решил "повиснуть"
        } else {
            throw new RuntimeException(); // или бросить исключение
        }
        }
 }

 class App17 {
    public static void main(String[] args) {
        // sqr - "сломается" (из него "выскочит" исключение),
        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        System.out.println(d); // и печатать нам ничего не придется!
    }
    public static double sqr(double arg) {
        throw new RuntimeException(); // "бросаем" исключение
    }
}


class Task1 {

    public static int area1(int width, int height) {
        return width*height;
    }

    public static int area2(int width, int height) {
        if (width < 0 || height < 0) {
            System.out.println("Your args are bad");
        } else {
            return width * height;
        }
        return -1;
    }

    public static int area3(int width, int height) {
        if (width < 0 || height < 0) {
            System.out.println("Your args are bad");
        }
        return width * height;
    }

    public static int area4(int width, int height) {
        if (width < 0 || height < 0) {
            return -1;
        }
        return width * height;
    }

    public static int area5(int width, int height) {
        if (width < 0 || height < 0) {
            System.exit(0);
        }
        return width * height;
    }

    // correct way
    public static int area6(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

}

 class App18 {
    public static void main(String[] args) {
        int x = 42;
        int y = x * x;
        x = x * y;

    }
}

class App19 {
    public static void main(String[] args) {
        if (args.length > 2) {
            //first step
            //second step
        } else {
            //first step
            //second step
        }
        //third step
    }
}

 class App20 {
    public static void main(String[] args) {
        int x = 1;
        do {

        } while (x++ < 10);

    }
}

/**
 * show:
 * #1.in
 * .   #2.in
 * .   .   #3.in
 * .   .   .   #4.in
 * .   .   .   #4.RETURN
 * .   .   #3.out
 * .   #2.out
 * #1.out
 *
 * like errors
 */
 class App21 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out");  //вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN");
            return; // выходим из текущего фрейма по 'return'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСКАЕМ
    }
}

/**
 * Error in h()
 */
 class App22 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // ПРОПУСТИЛИ!
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * #1.in
 * .   #2.in
 * .   .   #3.in
 * .   .   .   #4.in
 * .   .   .   #4.THROW
 * #1.CATCH
 * #1.out
 */
 class App23 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        try {
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println("#1.CATCH");  // и работаем
        }
        System.err.println("#1.out");  // работаем дальше
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}


/**
 * #1.in
 * .   #2.in
 * .   .   #3.in
 * .   .   .   #4.in
 * .   .   .   #4.THROW
 * .   #2.CATCH
 * .   #2.out
 * #1.out
 */
 class App24 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        try {
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   #2.CATCH");  // и работаем
        }
        System.err.println(".   #2.out");  // работаем дальше
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * #1.in
 * .   #2.in
 * .   .   #3.in
 * .   .   .   #4.in
 * .   .   .   #4.THROW
 * .   .   #3.CATCH
 * .   .   #3.out
 * .   #2.out
 * #1.out
 */
 class App25 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // вернулись и работаем
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   .   #3.CATCH");  // и работаем
        }
        System.err.println(".   .   #3.out");  // работаем дальше
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

/**
 * show:
 *  0 2 3
 */
 class App26 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
}

/**
 * Это RuntimeException на самом деле!!!
 */
 class App27 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
}

/**
 * 0Exception in thread "main" java.lang.Exception
 */
 class App28 {
    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
        try {
            System.err.print(" 0");
            if (true) {throw new Exception();}
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
}

/**
 *0Exception in thread "main" java.lang.Error
 */
 class App29 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch (Exception e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
}

/**
 *0 2Exception in thread "main" java.lang.Error
 */
 class App30 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // но бросили Error
        }
        System.err.println(" 3");          // пропускаем - уже летит Error
    }
}

/**
 *0 2Exception in thread "main" java.lang.RuntimeException
 */
 class App31 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw e;}       // и бросили ВТОРОЙ раз ЕГО ЖЕ
        }
        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
    }
}

/**
 *0 2Exception in thread "main" java.lang.Error
 */
 class App32 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

/**
 * 0 2.1 2.2 2.4 2.5 4
 */
 class App33 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {throw new Error();} // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

/**
 * nothing
 */
 class App34 {
    public static void main(String[] args) {
        try {
        } catch (Exception e) {
       // } catch (RuntimeException e) { // wrong
        }
    }
}

/**
 * nothing
 */
 class App35 {
    public static void main(String[] args) {
        try {
        } catch (Error e) {
        } catch (RuntimeException e) {
        }
    }
}

/**
 *catch Exception
 * next statement
 */
 class App36 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}

/**
 *catch Exception
 * next statement
 */
 class App37 {
    public static void main(String[] args) {
        try {
            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}

/**
 *try
 * finally
 */
 class App38 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }
}
/**
*finally
 * Exception in thread "main" java.lang.RuntimeException
 */
 class App39 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 *finally
 */
 class App40 {
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * nothing
 */
 class App41 {
    public static void main(String[] args) {
        try {
            System.exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * nothing
 */
 class App42 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 * nothing
 */
 class App43 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }
}

/**
 *try
 * finally
 * Exception in thread "main" java.lang.RuntimeException
 */
 class App44 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {throw new RuntimeException();}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

/**
 * the same
 */
 class App45 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
        //System.err.println("more"); // compile error
    }
}

/**
 * try
 * finally
 */
 class App46 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

/**
 * 1
 */
 class App47 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}

/**
 * 1
 */
 class App48 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }
}

/**
 *Exception
 */
 class App49 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            throw new RuntimeException();
        }
    }
}

/**
 *RuntimeException
 */
 class App50 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new Error();
        } finally {
            throw new RuntimeException();
        }
    }
}

/**
 * -1
 */
 class App51 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        long rnd = System.currentTimeMillis();
        boolean finished = false;
        try {
            if (rnd % 3 == 0) {
                throw new Error();
            } else if (rnd % 3 == 1) {
                throw new RuntimeException();
            } else {
                // nothing
            }
            finished = true;
        } finally {
            if (finished) {
                // не было исключений
            } else {
                // было исключение, но какое?
            }
        }
        return -1;
    }
}

/**
 * 0 1 3 4
 */
 class App52 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            // nothing
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 *  0 2 3 4
 */
 class App53 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 * 0 3
 */
 class App54 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

/**
 * nothing
 */
 class App55 {
    public static void main(String[] args) {
        if (args.length > 1) {
            if (args.length > 2) {
                if (args.length > 3) {
                    //some code
                }
            }
        }
    }
}

/**
 * nothing
 */
 class App56 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; i++) {
                for (int k = 0; k < 10; k++) {
                    //some code
                }
            }
        }
    }
}

/**
 *  0 1 2 4 5 7 8
 */
 class App57 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                // НИЧЕГО
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - нет исключения
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение в норме
        } catch (Exception e) {
            System.err.print(" 6");     // НЕ заходим - нет исключения
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
}

/**
 *  0 1 3 4 5 7 8
 */
 class App58 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new RuntimeException();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // ЗАХОДИМ - есть исключение
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

/**
 * 0 1 4 6 7 8
 */
 class App59 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Exception();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // не заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // ЗАХОДИМ - есть подходящее исключение
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

/**
 *  0 1 4 7Exception in thread "main" java.lang.Error
 */
 class App60 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Error();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // НЕ заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // не заходим - выполнение НЕ в норме
    }
}


 class App61 {
    public static void main(String[] args) {
        //throw new Exception();
    }
}

 class App62 {
    public static void main(String[] args) throws IOException {
        //throw new Exception(); // тут ошибка компиляции
    }
}

class App63 {
    public static void main(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
}

class App64 {
    public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
}

class App65 {
    public static void main(String[] args) throws Exception { // пугаем
        // но ничего не бросаем
    }
}

 class App66 {
    public static void main(String[] args) {
        //f(); // тут ошибка компиляции
    }

    public static void f() throws Exception {
    }
}

 class App67 {
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }
    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }
}

class App68 {
    public static byte[] method(String url) throws IOException {
        return "<html><body>Nothing! It's stub!</body></html>".getBytes();
    }
}

class App69 {
    public static void main(String[] args) {
        f();
    }
    public static void f() throws RuntimeException {
    }
}

 class App70 {
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

class App71 {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
}

 class App72 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

class App73 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
}

class App74 {
    public static void main(String[] args) throws IOException, InterruptedException {
        f0();
        f1();
        f2();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
    public static void f2() throws InterruptedException {}
}

class App75 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            // ...
        }
    }
}

class App76 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Throwable e) {
            // ...
        }
    }
}

class App77 {
    public static void main(String[] args) {
        try {
            //throw new Throwable();
        } catch (Exception e) {
            // ...
        }
    }
}

 class App78 {
    public static void main(String[] args) {
        try {
            //throw new Exception();
        } catch (Error e) {
            // ...
        }
    }
}

class App79 {
    // EOFException перехватили catch-ом, им не пугаем
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            // ...
        }
    }
}

class App80 {
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        Throwable t = new Exception(); // и лететь будет Exception
        //throw t; // но тут ошибка компиляции
    }
}

class App81 {
    public static void main(String[] args) throws Exception {
        Object ref = "Hello!";  // ref указывает на строку
       // char c = ref.charAt(0); // но тут ошибка компиляции
    }
}

class App82 {
    public static void f0(Throwable t) throws Exception {
        //throw t;
    }
    public static void f1(Object ref){
        //char c = ref.charAt(0);
    }
}

class App83 {
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        try {
            Throwable t = new Exception(); // и лететь будет Exception
            //throw t; // но тут ошибка компиляции
        } catch (Exception e) {
            System.out.println("Перехвачено!");
        }
    }
}

class App84 {
    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }
}

class Parent1 {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {}
}

class Child1 extends Parent1 {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws FileNotFoundException {}
}

class Parent2 {
    public void f() throws IOException, InterruptedException, Exception {}
}

class ChildB extends Parent2 {
    @Override
    public void f() throws Exception {}
}

class Parent3 {
    // предок пугает Exception
    public void f() throws Exception {}
}

class Child2 extends Parent3 {
    // потомок расширил Exception до Throwable
    //public void f() throws Throwable {}
}

class Demo {
    public static void test(Parent3 ref) {
        // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
        try {
            ref.f();
        } catch(Exception e) {}
    }
}

class App85 {
    public static void main(String[] args) {
        // тут все компилируется, Demo.test хотел Parent и мы дали ему подтип - Child
        Demo.test(new Child2());
    }
}