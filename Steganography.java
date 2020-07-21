package prototype;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;
import javax.crypto.spec.PBEParameterSpec;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Steganography {

	public boolean feasible = true;
	private AudioInputStream audioInputStream;
    private byte[] audioBytes;
    private byte[] buff;
    private byte[] cipherbuff;
    
    private String outFile;
    char[] password;
    PBEKeySpec pbeKeySpec;
//    public Steganography(String inputAudioFileString, String inputTextFileString, String outputAudioFileString) {
//		// TODO Auto-generated constructor stub
//	}

    //constructor 1
    public Steganography (String soundFile,String ptFile, String outputFile,char pwd[]){
      	password = pwd;
      	outFile=outputFile;
        readSound(soundFile);
        feasible = possible(ptFile);
    }
    //--------------------------------------------------------------------------------------------
    public void encode(){
    	
    	int k = 0;
        int i = 1; //start of plaintext in audioBytes
        int pt;
        byte pb;

        System.out.println("Hiding the ciphertext in Audio file ...");
        // First encode the length of the plaintext
        pt = cipherbuff.length;
        for (int j = 1; j <= 32; j++) {//4 bytes of space for length: 4bytes*8bit = 32 bits

            if ((pt & 0x80000000) != 0) // MSB of pt is '1'
            {
                audioBytes[i] = (byte) (audioBytes[i] | 0x01);
            } else if ((audioBytes[i] & 0x01) != 0) { //MSB of pt '0' and lsb of audio '1'
                audioBytes[i] = (byte) (audioBytes[i] >>> 1);
                audioBytes[i] = (byte) (audioBytes[i] << 1);
            }//if
            pt = (int) (pt << 1);
            i++;
        }

    // Now encoding the message itself!
        
        while (k < cipherbuff.length) {
            pb = cipherbuff[k];
            //System.out.print((char)pt);
            for (int j = 1; j <= 8; j++) {
                if ((pb & 0x80) != 0) // MSB of pb is '1'
                {
                    audioBytes[i] = (byte) (audioBytes[i] | 0x01);
                } else if ((audioBytes[i] & 0x01) != 0) { //MSB of pt '0' and lsb of audio '1'
                    audioBytes[i] = (byte) (audioBytes[i] >>> 1);
                    audioBytes[i] = (byte) (audioBytes[i] << 1);
                }//if
                pb = (byte) (pb << 1);
                i++;
            }//for j
            k++;
        }//while k
        System.out.println();
        // now write the byte array to an audio file
        File fileOut = new File(outFile);
        ByteArrayInputStream byteIS = new ByteArrayInputStream(audioBytes);
        AudioInputStream audioIS = new AudioInputStream(byteIS,
                audioInputStream.getFormat(), audioInputStream.getFrameLength());
        if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.AU,
                audioIS)) {
            try {
                AudioSystem.write(audioIS, AudioFileFormat.Type.AU, fileOut);
                System.out.println("Steganographed AU file is written as " + outFile + "...");
            } catch (Exception e) {
                System.err.println("Sound File write error");
            }
        }//if
    }//encode
//-----------------------------------------------------------------------------
    public boolean decode() {
        boolean success = true;
        byte out = 0;
        int length = 0;
        int k = 1; //start of plaintext in audioBytes
        System.out.println("Retrieving the ciphertext from AU file ....");
        
        
        // Now decode the message!
        
        
        try {
            System.out.println("Writing the decrypted hidden message to" + outFile + " ...");
            FileOutputStream outfile = new FileOutputStream(outFile);
            
            outfile.close();
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }

        return success;
    }//decode
  //-------------------------------------------------------------------
    
    public void readSound(String sfile) {
    	File sndfile = new File(sfile);
    	
    	int totalFramesRead = 0;
    	
    	System.out.println("Reading (AU) Audio file");
    	
    	try {
			audioInputStream = AudioSystem.getAudioInputStream(sndfile);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			// Set an arbitrary buffer size of 1024 frames.
            int numBytes = 154600 * bytesPerFrame;
            audioBytes = new byte[numBytes];
            
            try {
                int numBytesRead = 0;
                int numFramesRead = 0;
                // Try to read numBytes bytes from the file.
                while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
                    // Calculate the number of frames actually read.
                    numFramesRead = numBytesRead / bytesPerFrame;
                    totalFramesRead += numFramesRead;
            // Now work with the audio data that's 
           // now in the audioBytes array    
                }
            } catch (Exception ex) {
                // Handle the error
                System.out.println("Audio file error:" + ex);
            }
        } catch (Exception e) {
            // Handle the erro
            System.out.println("Audio file error:" + e);
        }
    }
 // To check if it is possible to do steganography with current file
    private boolean possible(String pt) {
        // accessing the input file
        try {
            System.out.println("Reading the plaintext file ..." + pt);
            FileInputStream fis = new FileInputStream(pt);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int len = bis.available();
            buff = new byte[len];

            while (bis.available() != 0) {
                len = bis.read(buff);
            }
            bis.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Could Not Read Plain Text Caught Exception: " + e);
        }

        try {
            encrypt();
            if (cipherbuff.length * 8 > audioBytes.length) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("******Exception: " + e);
        }
        return true;
    }// possible()
    //---------------------------------------------------------
    
  //---------------------------------------------------------
    // Reads user password from given input stream.
    //---------------------------------------------------------

    private char[] readPasswd(InputStream in) throws IOException {
        char[] lineBuffer;
        char[] buf;
        int i;

        buf = lineBuffer = new char[128];

        int room = buf.length;
        int offset = 0;
        int c;

        loop:
        while (true) {
            switch (c = in.read()) {
                case -1:
                case '\n':
                    break loop;

                case '\r':
                    int c2 = in.read();
                    if ((c2 != '\n') && (c2 != -1)) {
                        if (!(in instanceof PushbackInputStream)) {
                            in = new PushbackInputStream(in);
                        }
                        ((PushbackInputStream) in).unread(c2);
                    } else {
                        break loop;
                    }

                default:
                    if (--room < 0) {
                        buf = new char[offset + 128];
                        room = buf.length - offset - 1;
                        System.arraycopy(lineBuffer, 0, buf, 0, offset);
                        Arrays.fill(lineBuffer, ' ');
                        lineBuffer = buf;
                    }
                    buf[offset++] = (char) c;
                    break;
            }//switch
        }
        if (offset == 0) {
            return null;
        }
        char[] ret = new char[offset];
        System.arraycopy(buf, 0, ret, 0, offset);
        Arrays.fill(buf, ' ');
        System.out.println("Password Captured: " + ret);
        return ret;
    }//read password

   //-------------------------------------------------
    // Password based encryption
    //-------------------------------------------------
    private void encrypt() {
        // PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac;

        // Salt
        byte[] salt = {
            (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
            (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99
        };

        // Iteration count
        int count = 20;

        // Create PBE parameter set
        pbeParamSpec = new PBEParameterSpec(salt, count);//Constructs a parameter set for password-based encryption as defined in the PKCS #5 standard.


     // Prompt user for encryption password.
        // Collect user password as char array (using the
        // "readPasswd" method from above), and convert
        // it into a SecretKey object, using a PBE key
        // factory.
        try {

            System.out.println("Password Verification: " + password);

            pbeKeySpec = new PBEKeySpec(password);//Constructor that takes a password.
            System.out.println("Encrypting the plaintext message ...");

            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

            // Create PBE Cipher
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            // Initialize PBE Cipher with key and parameters
            pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

     // Our input cleartext
            
            // Encrypt the cleartext
            cipherbuff = pbeCipher.doFinal(buff);
        } catch (Exception ex) {
            // Handle the error...
            System.out.println("Caught Exception: " + ex);
            ex.printStackTrace();
        }

    }//encrypt()

   //-------------------------------------------------
    
}