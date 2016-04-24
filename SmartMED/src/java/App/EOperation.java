package App;

public enum EOperation
{
    GenerateRegister("register"),
    ExecuteRegister("execute-register"),
    ExecuteLogin("execute-login"),
    InvalidOperation("invalid");

    public final String OperationCode;

    public static final String OperationParamName = "op";   // name of the HTML request parameter

    private EOperation(String operationCode)
    {
        OperationCode = operationCode;
    }

    public String getOperationCode()
    {
        return OperationCode;
    }

    public static EOperation ParseString(String str)
    {
        if (str != null)
        {
            for (EOperation operation : EOperation.values())
            {
                if (operation.OperationCode.compareTo(str) == 0)
                {
                    return operation;
                }
            }
        }

        return InvalidOperation;
    }
}
