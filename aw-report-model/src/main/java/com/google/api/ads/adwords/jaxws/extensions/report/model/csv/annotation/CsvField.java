package com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to map a field in the CSV file to the annotated bean property.
 *
 *  The CSV is constructed based on the mapping between the report property selected and the file
 * created.
 *
 * @author gustavomoreira@google.com (Gustavo Moreira)
 *
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface CsvField {

  /**
   * The name of the property in the CSV file.
   */
  String value();

  /**
   * The report field on the API that will be selected to download.
   */
  String reportField();

}
