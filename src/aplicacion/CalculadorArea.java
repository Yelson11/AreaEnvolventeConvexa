package aplicacion;

import java.util.ArrayList;
import java.util.Vector;

public class CalculadorArea {

	public CalculadorArea() {
	}
	
	public static int orientation(Punto p, Punto q, Punto r)
    {
        int val = (q.getPosY() - p.getPosY()) * (r.getPosX() - q.getPosX()) -
                  (q.getPosX() - p.getPosX()) * (r.getPosY() - q.getPosY());

        if (val == 0) return 0;
        return (val > 0)? 1: 2;
    }

    public static void convexHull(Punto Puntos[], int n)
    {
        if (n < 3) return;
        Vector<Punto> hull = new Vector<Punto>();
        int l = 0;
        for (int i = 1; i < n; i++)

            if (Puntos[i].getPosX() < Puntos[l].getPosX())
                l = i;

        int p = l, q;
        do
        {
            hull.add(Puntos[p]);

            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
               if (orientation(Puntos[p], Puntos[i], Puntos[q]) == 2)
                   q = i;
            }


            p = q;

        } while (p != l);


        for (Punto temp : hull)
            System.out.println("(" + temp.getPosX() + ", " +
                                temp.getPosX() + ")");
    }

    public Vector<Punto> ConvertirHull (ArrayList<Punto> Puntos, int n){
        if (n < 3) return null;
        Vector<Punto> hull = new Vector<Punto>();
        int l = 0;
        Punto punto1, punto2;
        for (int i = 1; i < n; i++){
        punto1=Puntos.get(i);
		punto2=Puntos.get(l);

            if (punto1.getPosX() < punto2.getPosX())
                l = i;
            }
        int p = l, q;
        do
        {
            hull.add(Puntos.get(p));

            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
               if (orientation(Puntos.get(p), Puntos.get(i), Puntos.get(q)) == 2)
                   q = i;
            }


            p = q;

        } while (p != l);


        for (Punto temp : hull)
            System.out.println("(" + temp.getPosX() + ", " +
                                temp.getPosX() + ")");
        return hull;
    }
}
