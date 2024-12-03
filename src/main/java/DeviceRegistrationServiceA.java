
import org.apache.commons.codec.digest.DigestUtils;

public class DeviceRegistrationServiceA {
    public String registerDevice(String macId, String deviceFingerprint, String userCredentials) {
        String rawData = macId + deviceFingerprint + userCredentials;
        // Benzersiz cihaz kimlik belirteci oluşturma (SHA-256)
        String deviceToken = DigestUtils.sha256Hex(rawData);
        // Cihaz belirtecini güvenli bir şekilde saklama
        saveDeviceToken(deviceToken);
        return deviceToken;
    }

    private void saveDeviceToken(String deviceToken) {
        // Cihaz belirtecini veritabanına veya güvenli bir depolama alanına kaydetme işlemi
        // Bu örnekte basitçe konsola yazdırıyoruz
        System.out.println("Cihaz belirteci kaydedildi: " + deviceToken);
    }
}
