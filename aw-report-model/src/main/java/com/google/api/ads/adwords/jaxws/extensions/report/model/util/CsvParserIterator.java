package com.google.api.ads.adwords.jaxws.extensions.report.model.util;

import com.google.common.collect.AbstractIterator;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.MappingStrategy;

/**
 * Iterator to read one line at a time from the CSV file.
 */
public class CsvParserIterator<T> extends AbstractIterator<T> {

  private final MappingStrategy<T> mapper;
  private final CSVReader csv;
  private final ModifiedCsvToBean<T> csvToBean;

  /**
   * @param mapper the mapping strategy for the bean
   * @param csv the CSV file reader
   * @param csvToBean the modified implementation of the {@code CsvToBean} to access the parsing
   *        methods
   */
  public CsvParserIterator(
      MappingStrategy<T> mapper, CSVReader csv, ModifiedCsvToBean<T> csvToBean) {
    this.mapper = mapper;
    this.csv = csv;
    this.csvToBean = csvToBean;
  }

  /**
   * @see com.google.common.collect.AbstractIterator#computeNext()
   */
  @Override
  protected T computeNext() {

    try {
      String[] line = this.csv.readNext();
      if (line != null) {
        return this.csvToBean.processLine(this.mapper, line);
      } else {
        this.endOfData();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  }

}
