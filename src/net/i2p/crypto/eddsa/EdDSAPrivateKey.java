package net.i2p.crypto.eddsa;

import java.math.BigInteger;
import java.security.PrivateKey;

import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;

/**
 * An EdDSA private key.
 * @author str4d
 *
 */
public class EdDSAPrivateKey implements EdDSAKey, PrivateKey {
    private transient final byte[] seed;
    private transient final byte[] h;
    private transient final BigInteger a;
    private transient final GroupElement A;
    private transient final byte[] Abyte;
    private transient final EdDSAParameterSpec edDsaSpec;

    public EdDSAPrivateKey(EdDSAPrivateKeySpec spec) {
        this.seed = spec.getSeed();
        this.h = spec.getH();
        this.a = spec.geta();
        this.A = spec.getA();
        this.Abyte = this.A.toByteArray();
        this.edDsaSpec = spec.getParams();
    }

    @Override
    public String getAlgorithm() {
        return "EdDSA";
    }

    @Override
    public String getFormat() {
        return "PKCS#8";
    }

    @Override
    public byte[] getEncoded() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EdDSAParameterSpec getParams() {
        return edDsaSpec;
    }

    public byte[] getSeed() {
        return seed;
    }

    public byte[] getH() {
        return h;
    }

    public BigInteger geta() {
        return a;
    }

    public GroupElement getA() {
        return A;
    }

    public byte[] getAbyte() {
        return Abyte;
    }
}
