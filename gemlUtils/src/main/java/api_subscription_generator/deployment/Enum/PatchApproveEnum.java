/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_subscription_generator.deployment.Enum;

/**
 * @author 502413934
 */
public enum PatchApproveEnum {

    Y(1),
    N(0);

    public final Integer value;

    PatchApproveEnum(final Integer value) {
        this.value = value;
    }

    public static PatchApproveEnum translate(String value) {
        return valueOf(value);
    }

}
