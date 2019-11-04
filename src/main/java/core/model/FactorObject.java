package core.model;

import core.model.player.IMatchRoleID;
import core.util.HOLogger;

public final class FactorObject {
    //~ Instance fields ----------------------------------------------------------------------------

    /** The position that is described by this FactorObject */
    private byte m_bPosition = IMatchRoleID.UNKNOWN;

    /** Influence of Winger for this position */
    private float fWing;

    /** Influence of Passing for this position */
    private float fPassing;

    /** Influence of Playmaking for this position */
    private float fPlaymaking;

    /** Influence of Set Pieces for this position */
    private float fSetPieces;

    /** Influence of Scoring for this position */
    private float fScoring;

    /** Influence of Goalkeeping for this position */
    private float fGoalkeeping;

    /** Influence of Defending for this position */
    private float fDefending;

    /** Normalization factor for this position */  //This is required to calculate the Ideal Position by normalizing player contribution across all positions (see #212)
    private float fNormalization;

    //~ Constructors -------------------------------------------------------------------------------

    /**
     * Creates a new instance of FactorObject
     */
    public FactorObject(byte position, float gk, float pm, float ps,
                        float wi, float de, float sc, float sp, float nf) {
        fScoring = sc;
        fGoalkeeping = gk;
        fSetPieces = sp;
        fPlaymaking = pm;
        fPassing = ps;
        fDefending = de;
        fWing = wi;
        m_bPosition = position;
        fNormalization = nf;
    }

    /**
     * Creates a new FactorObject object.
     */
    public FactorObject(java.sql.ResultSet rs) {
        try {
            if (rs != null) {
                fScoring = rs.getFloat("SCfactor");
                fGoalkeeping = rs.getFloat("GKfactor");
                fSetPieces = rs.getFloat("SPfactor");
                fPlaymaking = rs.getFloat("PMfactor");
                fPassing = rs.getFloat("PSfactor");
                fDefending = rs.getFloat("DEfactor");
                fWing = rs.getFloat("WIfactor");
                m_bPosition = rs.getByte("PositionID");
                fNormalization = rs.getFloat("NormalisationFactor");
            }
        } catch (Exception e) {
            HOLogger.instance().log(getClass(),"Konstruktor Faktor Obj: " + e.toString());
        }
    }

    //~ Methods ------------------------------------------------------------------------------------

    /**
     * Setter for property fWing.
     *
     * @param m_fFluegelspiel New value of property fWing.
     */
    public final void setWingerFactor(float m_fFluegelspiel) {
        this.fWing = m_fFluegelspiel;
    }


    /**
     * Setter for property fPassing.
     *
     * @param m_fPasspiel New value of property fPassing.
     */
    public final void setPassingFactor(float m_fPasspiel) {
        this.fPassing = m_fPasspiel;
    }


    /**
     * Setter for property m_bPosition.
     *
     * @param m_bPosition New value of property m_bPosition.
     */
    public final void setPosition(byte m_bPosition) {
        this.m_bPosition = m_bPosition;
    }

    /**
     * Getter for property m_bPosition.
     *
     * @return Value of property m_bPosition.
     */
    public final byte getPosition() {
        return m_bPosition;
    }

    /**
     * Setter for property fPlaymaking.
     *
     * @param m_fSpielaufbau New value of property fPlaymaking.
     */
    public final void setPlaymakingFactor(float m_fSpielaufbau) {
        this.fPlaymaking = m_fSpielaufbau;
    }


    /**
     * Setter for property fSetPieces.
     *
     * @param m_fStandards New value of property fSetPieces.
     */
    public final void setSetPiecesFactor(float m_fStandards) {
        this.fSetPieces = m_fStandards;
    }


    //HelperFuncs//////
    public final float getSum() {
        return (fGoalkeeping + fSetPieces + fScoring + fDefending + fWing
               + fPassing + fPlaymaking);
    }

    /**
     * Setter for property fScoring.
     *
     * @param m_fTorschuss New value of property fScoring.
     */
    public final void setTorschuss(float m_fTorschuss) {
        this.fScoring = m_fTorschuss;
    }

    /**
     * Setter for property m_iTorwart.
     *
     * @param m_iTorwart New value of property m_iTorwart.
     */
    public final void setTorwart(float m_iTorwart) {
        this.fGoalkeeping = m_iTorwart;
    }

    ///////////////Accessor//////////////////////

    /**
     * Setter for property fDefending.
     *
     * @param m_fVerteidigung New value of property fDefending.
     */
    public final void setDefendingFactor(float m_fVerteidigung) {
        this.fDefending = m_fVerteidigung;
    }


    public final void setNormalizationFactor(float fNormalization) {
        this.fNormalization = fNormalization;
    }

	public float getWIfactor() {
		return fWing;
	}

	public float getPSfactor() {
		return fPassing;
	}

	public float getPMfactor() {
		return fPlaymaking;
	}

	public float getSPfactor() {
		return fSetPieces;
	}

	public float getSCfactor() {
		return fScoring;
	}

    public float getNormalizationFactor() {
        return fNormalization;
    }

	public float getGKfactor() {
		return fGoalkeeping;
	}

	public float getDEfactor() {
		return fDefending;
	}

}
