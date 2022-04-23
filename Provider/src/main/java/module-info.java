import org.example.convert.Converter;
import org.example.provide.DkkConverter;
import org.example.provide.EuroConverter;

module org.example.provider {
    requires org.jetbrains.annotations;
    requires org.example.converter;
    provides Converter with EuroConverter, DkkConverter;

}