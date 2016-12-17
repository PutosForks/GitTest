/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_subscription_generator.deployment.Enum;

/**
 * @author 502413934
 */
public enum ObjectTypeEnum {

	bdy("BDY"),
	mv("DDL"),
	tab("DDL"),
	fnc("F"),
	idx("MM"),
	prc("P"),
	seq("SEQ"),
	NN("SPC"),
	spc("SPC"),
	syn("SYN"),
	tpb("TPB"),
    tps("TPS"),
    trg("TRG"),
    vw("V"),
    sql("MM"),
    pls("MM");

    public final String value;

    ObjectTypeEnum(final String value) {
        this.value = value;
    }

    public static ObjectTypeEnum translate(String value) {
        return valueOf(value);
    }

}
