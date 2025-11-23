package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();    //
    String getSearchType();    //
    String getSearchableName();//

    default String getStringRepresentation() {
        return getSearchableName() + " — " + getSearchType();
    }
}
