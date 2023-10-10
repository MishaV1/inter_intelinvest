/*
 * STRICTLY CONFIDENTIAL
 * TRADE SECRET
 * PROPRIETARY:
 *       "Intelinvest" Ltd, TIN 1655386205
 *       420107, REPUBLIC OF TATARSTAN, KAZAN CITY, SPARTAKOVSKAYA STREET, HOUSE 2, ROOM 119
 * (c) "Intelinvest" Ltd, 2019
 *
 * СТРОГО КОНФИДЕНЦИАЛЬНО
 * КОММЕРЧЕСКАЯ ТАЙНА
 * СОБСТВЕННИК:
 *       ООО "Интеллектуальные инвестиции", ИНН 1655386205
 *       420107, РЕСПУБЛИКА ТАТАРСТАН, ГОРОД КАЗАНЬ, УЛИЦА СПАРТАКОВСКАЯ, ДОМ 2, ПОМЕЩЕНИЕ 119
 * (c) ООО "Интеллектуальные инвестиции", 2019
 */

package ru.intelinvest.career.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    @JsonProperty("SECID")
    public String secid;
    @JsonProperty("BOARDID")
    public String boardid;
    @JsonProperty("SHORTNAME")
    public String shortname;
    @JsonProperty("PREVPRICE")
    public double prevprice;
    @JsonProperty("LOTSIZE")
    public int lotsize;
    @JsonProperty("FACEVALUE")
    public double facevalue;
    @JsonProperty("STATUS")
    public String status;
    @JsonProperty("BOARDNAME")
    public String boardname;
    @JsonProperty("DECIMALS")
    public int decimals;
    @JsonProperty("SECNAME")
    public String secname;
    @JsonProperty("REMARKS")
    public Object remarks;
    @JsonProperty("MARKETCODE")
    public String marketcode;
    @JsonProperty("INSTRID")
    public String instrid;
    @JsonProperty("SECTORID")
    public Object sectorid;
    @JsonProperty("MINSTEP")
    public double minstep;
    @JsonProperty("PREVWAPRICE")
    public double prevwaprice;
    @JsonProperty("FACEUNIT")
    public String faceunit;
    @JsonProperty("PREVDATE")
    public String prevdate;
    @JsonProperty("ISSUESIZE")
    public Object issuesize;
    @JsonProperty("ISIN")
    public String isin;
    @JsonProperty("LATNAME")
    public String latname;
    @JsonProperty("REGNUMBER")
    public String regnumber;
    @JsonProperty("PREVLEGALCLOSEPRICE")
    public double prevlegalcloseprice;
    @JsonProperty("CURRENCYID")
    public String currencyid;
    @JsonProperty("SECTYPE")
    public String sectype;
    @JsonProperty("LISTLEVEL")
    public int listlevel;
    @JsonProperty("SETTLEDATE")
    public String settledate;
}
