package edu.unlam.paradigmas.tp.entidades;

import java.util.Arrays;
import java.util.Objects;

import edu.unlam.paradigmas.tp.enums.TipoDeAtraccion;
import edu.unlam.paradigmas.tp.enums.TipoDePromocion;

public abstract class Promocion {

	private TipoDeAtraccion tipoDeAtraccion;
	private Atraccion[] atracciones;
	private TipoDePromocion tipoDePromocion;

	private double precioOriginal;
	private double precioConDescuento;
	private double duracion;

	public Promocion(TipoDeAtraccion tipoDeAtraccion, Atraccion[] atracciones, TipoDePromocion tipoDePromocion) {

		this.tipoDeAtraccion = tipoDeAtraccion;
		this.atracciones = atracciones;
		this.tipoDePromocion = tipoDePromocion;

		// PREGUNTAR
		this.precioOriginal = calcularPrecioOriginalTotal(); 
		this.precioConDescuento = calcularPrecioConDescuento();
		this.duracion = calcularDuracionTotal();
	}

	protected double getPrecioOriginal() {
		return this.precioOriginal;
	}

	protected abstract double calcularPrecioConDescuento();

	protected double calcularPrecioOriginalTotal() {
		double precioOriginalTotal = 0;
		for (Atraccion atraccion : atracciones)
			precioOriginalTotal += atraccion.getPrecio();
		return precioOriginalTotal;
	}

	private double calcularDuracionTotal() {
		double duracionTotal = 0;
		for (Atraccion atraccion : atracciones)
			duracionTotal += atraccion.getTiempo();
		return duracionTotal;
	}

	public Atraccion[] getAtracciones() {
		return atracciones;
	}

	@Override
	public String toString() {
		return "Tipo de atraccion: " + tipoDeAtraccion + "\t\tAtracciones: " + Arrays.toString(atracciones)
				+ "\t\tTipo de promocion: " + tipoDePromocion + "\tPrecio orignal: " + precioOriginal
				+ "\tPrecio con descuento: " + precioConDescuento + "\tDuracion: " + duracion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(atracciones);
		result = prime * result
				+ Objects.hash(duracion, precioConDescuento, precioOriginal, tipoDeAtraccion, tipoDePromocion);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Arrays.equals(atracciones, other.atracciones)
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Double.doubleToLongBits(precioConDescuento) == Double.doubleToLongBits(other.precioConDescuento)
				&& Double.doubleToLongBits(precioOriginal) == Double.doubleToLongBits(other.precioOriginal)
				&& tipoDeAtraccion == other.tipoDeAtraccion && tipoDePromocion == other.tipoDePromocion;
	}

}
