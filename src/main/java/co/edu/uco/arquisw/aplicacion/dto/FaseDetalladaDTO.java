package co.edu.uco.arquisw.aplicacion.dto;

public class FaseDetalladaDTO
{
    private int codigo;
    private String nombre;
    private String descripcion;
    private int orden;

    public FaseDetalladaDTO()
    {

    }

    public FaseDetalladaDTO(int codigo, String nombre, String descripcion, int orden)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public int getOrden()
    {
        return orden;
    }

    public void setOrden(int orden)
    {
        this.orden = orden;
    }
}