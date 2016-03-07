package SmartMED;

public enum EAppOperation
{
    Example("example"),
    Login("login"),
    InvalidOperation("invalid");

    public final String OperationCode;

    public static final String OperationParamName = "op";   // name of the HTML request parameter

    private EAppOperation(String operationCode)
    {
        OperationCode = operationCode;
    }

    public String getOperationCode()
    {
        return OperationCode;
    }

    public static EAppOperation ParseString(String str)
    {
        if (str != null)
        {
            for (EAppOperation operation : EAppOperation.values())
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
