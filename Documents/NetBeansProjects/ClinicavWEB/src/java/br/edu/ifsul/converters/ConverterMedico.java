package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@FacesConverter(value = "converterMedico")
public class ConverterMedico implements Converter, Serializable {

    @PersistenceContext(unitName = "webPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        return em.find(Medico.class, Integer.parseInt(string));

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        Medico m = (Medico) o;
        return m.getId().toString();
    }
}
