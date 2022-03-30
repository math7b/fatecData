package fatec.poo.model;

/**
 *
 * @author matheusBarth
 */
public class Retangulo {

    private double altura;
    private double base;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double calcArea() {
        return (altura * base);
    }

    public double calcPerimetro() {
        return (2 * (altura + base));
    }

    public double calcDiagonal() {
        return (Math.sqrt(Math.pow(altura, 2) + Math.pow(base, 2)));
    }
}
