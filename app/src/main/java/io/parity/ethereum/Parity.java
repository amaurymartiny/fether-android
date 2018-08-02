package io.parity.ethereum;

public class Parity {

    // Used to load 'libparity' library on application startup.
    static {
        System.loadLibrary("parity");
    }

    public Parity(String[] options) {
        long config = configFromCli(options);
        inner = build(config);
    }

    public String rpcQuery(String query) {
        return rpcQueryNative(inner, query);
    }

    protected void finalize​() {
        destroy(inner);
    }

    private static native long configFromCli(String[] cliOptions);
    private static native long build(long config);
    private static native void destroy(long inner);
    private static native String rpcQueryNative(long inner, String rpc);

    private long inner;
}
