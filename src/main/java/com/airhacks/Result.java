/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

/**
 *
 * @author tss
 */
public class Result
{

    public enum result
    {
        SUCCESS,
        FAILURE_DATA_ALREADY_PRESENT,
        FAILURE_DATA_NOT_VALID;
    }

    private result result;

    public result getResult()
    {
        return (this.result);
    }

    public Result(String value)
    {
        switch (value)
        {
            case "SUCCESS":
                this.result = result.SUCCESS;
                break;
            case "FAILURE_DATA_ALREADY_PRESENT":
                this.result = result.FAILURE_DATA_ALREADY_PRESENT;
                break;
            case "FAILRE_DATA_NOT_VALID":
                this.result = result.FAILURE_DATA_NOT_VALID;
                break;
        }
    }
}
