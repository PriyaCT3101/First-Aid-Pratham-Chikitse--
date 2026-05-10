package org.vtu.mindmatrix.prathamchikitse.data

import org.vtu.mindmatrix.prathamchikitse.data.model.EmergencyCase
import org.vtu.mindmatrix.prathamchikitse.data.model.EmergencyStep
import org.vtu.mindmatrix.prathamchikitse.data.model.Hospital

object EmergencyRepository {
    val cases: List<EmergencyCase> = listOf(
        EmergencyCase(
            1, "Burns", "ಸುಟ್ಟ ಗಾಯ", "ic_burn", "High",
            listOf(
                EmergencyStep(1, "Stop the burning", "ಸುಡುವುದನ್ನು ತಡೆಯಿರಿ", "Ensure the person is no longer in contact with the heat source or fire. If clothes are on fire, stop, drop, and roll.", "ವ್ಯಕ್ತಿಯು ಶಾಖದ ಮೂಲ ಅಥವಾ ಬೆಂಕಿಯೊಂದಿಗೆ ಸಂಪರ್ಕದಲ್ಲಿಲ್ಲ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ. ಬಟ್ಟೆಗೆ ಬೆಂಕಿ ಹತ್ತಿದ್ದರೆ, ತಕ್ಷಣ ನಿಂತು ಮಲಗಿ ಹೊರಳಾಡಿ.", true, "ic_burn"),
                EmergencyStep(2, "Cool for 20 minutes", "20 ನಿಮಿಷ ತಂಪಾಗಿಸಿ", "Hold the burned area under cool (not cold) running water for at least 20 minutes. This limits tissue damage.", "ಸುಟ್ಟ ಭಾಗವನ್ನು ಕನಿಷ್ಠ 20 ನಿಮಿಷಗಳ ಕಾಲ ತಂಪಾದ (ತಣ್ಣಗಿನ ಅಲ್ಲ) ಹರಿಯುವ ನೀರಿನಡಿ ಇಡಿ. ಇದು ಅಂಗಾಂಶದ ಹಾನಿಯನ್ನು ಕಡಿಮೆ ಮಾಡುತ್ತದೆ.", true, "ic_cold"),
                EmergencyStep(3, "Remove constrictions", "ಬಿಗಿಯಾದ ವಸ್ತು ತೆಗೆಯಿರಿ", "Gently remove rings, watches, or jewelry near the burn before the area starts to swell.", "ಗಾಯಗೊಂಡ ಭಾಗ ಊದಿಕೊಳ್ಳುವ ಮೊದಲು ಉಂಗುರ, ಗಡಿಯಾರ ಅಥವಾ ಆಭರಣಗಳನ್ನು ಎಚ್ಚರಿಕೆಯಿಂದ ತೆಗೆಯಿರಿ.", true, "ic_bandage"),
                EmergencyStep(4, "Cover with plastic wrap", "ಪ್ಲಾಸ್ಟಿಕ್ ಹೊದಿಕೆ ಬಳಸಿ", "Loosely cover the burn with clean plastic wrap or a clear plastic bag to keep it clean and reduce pain.", "ಗಾಯವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡಲು ಮತ್ತು ನೋವು ಕಡಿಮೆ ಮಾಡಲು ಪ್ಲಾಸ್ಟಿಕ್ ಹೊದಿಕೆ ಅಥವಾ ಕ್ಲೀನ್ ಬ್ಯಾಗ್‌ನಿಂದ ಸಡಿಲವಾಗಿ ಮುಚ್ಚಿ.", true, "ic_bandage"),
                EmergencyStep(5, "Do not use ice", "ಐಸ್ ಬಳಸಬೇಡಿ", "Never apply ice directly to a burn, as it can cause further damage to the skin tissues.", "ಗಾಯಕ್ಕೆ ನೇರವಾಗಿ ಐಸ್ ಹಚ್ಚಬೇಡಿ, ಇದು ಚರ್ಮದ ಅಂಗಾಂಶಗಳಿಗೆ ಹೆಚ್ಚಿನ ಹಾನಿ ಉಂಟುಮಾಡಬಹುದು.", false, "ic_warning"),
                EmergencyStep(6, "Do not pop blisters", "ಗುಳ್ಳೆಗಳನ್ನು ಒಡೆಯಬೇಡಿ", "Leave any blisters alone. Popping them increases the risk of serious infection.", "ಚರ್ಮದ ಮೇಲಿನ ಗುಳ್ಳೆಗಳನ್ನು ಹಾಗೆಯೇ ಬಿಡಿ. ಅವುಗಳನ್ನು ಒಡೆದರೆ ಸೋಂಕು ಹರಡುವ ಅಪಾಯ ಹೆಚ್ಚು.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            2, "Severe Bleeding", "ತೀವ್ರ ರಕ್ತಸ್ರಾವ", "ic_bleeding", "Critical",
            listOf(
                EmergencyStep(1, "Direct Pressure", "ನೇರ ಒತ್ತಡ ಹಾಕಿ", "Apply firm, steady pressure directly on the wound using a clean cloth or sterile gauze.", "ಸ್ವಚ್ಛ ಬಟ್ಟೆ ಅಥವಾ ಗಾಜಿನ ಬಟ್ಟೆಯನ್ನು ಬಳಸಿ ಗಾಯದ ಮೇಲೆ ನೇರವಾಗಿ ಮತ್ತು ದೃಢವಾಗಿ ಒತ್ತಡ ಹಾಕಿ.", true, "ic_bleeding"),
                EmergencyStep(2, "Maintain pressure", "ಒತ್ತಡ ಮುಂದುವರಿಸಿ", "Keep pressing for at least 10 minutes without lifting the cloth to check if it has stopped.", "ರಕ್ತ ನಿಂತಿದೆಯೇ ಎಂದು ನೋಡಲು ಬಟ್ಟೆ ಎತ್ತದೆ ಕನಿಷ್ಠ 10 ನಿಮಿಷಗಳ ಕಾಲ ನಿರಂತರವಾಗಿ ಒತ್ತಿರಿ.", true, "ic_bleeding"),
                EmergencyStep(3, "Add more layers", "ಹೆಚ್ಚುವರಿ ಪದರ ಸೇರಿಸಿ", "If blood soaks through, do not remove the first cloth. Place another one on top and keep pressing.", "ರಕ್ತವು ಬಟ್ಟೆಯಲ್ಲಿ ನೆನೆದರೆ, ಆ ಬಟ್ಟೆಯನ್ನು ತೆಗೆಯಬೇಡಿ. ಅದರ ಮೇಲೆ ಮತ್ತೊಂದು ಬಟ್ಟೆ ಇಟ್ಟು ಒತ್ತಡ ಮುಂದುವರಿಸಿ.", true, "ic_bandage"),
                EmergencyStep(4, "Elevate the wound", "ಗಾಯದ ಭಾಗ ಎತ್ತಿ ಹಿಡಿಯಿರಿ", "Raise the injured limb above the level of the heart to slow down the blood flow.", "ರಕ್ತದ ಹರಿವನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಗಾಯಗೊಂಡ ಅಂಗವನ್ನು ಹೃದಯದ ಮಟ್ಟಕ್ಕಿಂತ ಮೇಲೆ ಎತ್ತಿ ಹಿಡಿಯಿರಿ.", true, "ic_elevate"),
                EmergencyStep(5, "Monitor for shock", "ಶಾಕ್ ಆಗುತ್ತಿದೆಯೇ ಗಮನಿಸಿ", "Keep the person warm and lying down. Look for signs like pale skin, dizziness, or cold sweat.", "ವ್ಯಕ್ತಿಯನ್ನು ಬೆಚ್ಚಗೆ ಮತ್ತು ಮಲಗಿಸಿಡಿ. ಚರ್ಮ ಬಿಳಿಯಾಗುವುದು, ತಲೆತಿರುಗುವಿಕೆ ಅಥವಾ ಶೀತದ ಬೆವರುವಿಕೆ ಗಮನಿಸಿ.", true, "ic_recovery"),
                EmergencyStep(6, "Do not remove objects", "ವಸ್ತುಗಳನ್ನು ತೆಗೆಯಬೇಡಿ", "If a knife or glass is stuck in the wound, do not pull it out. Apply pressure around it.", "ಚಾಕು ಅಥವಾ ಗಾಜು ಗಾಯದಲ್ಲಿ ಸಿಲುಕಿದ್ದರೆ, ಅದನ್ನು ಎಳೆಯಬೇಡಿ. ಅದರ ಸುತ್ತಲೂ ಒತ್ತಡ ಹಾಕಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            3, "Choking", "ಉಸಿರುಕಟ್ಟುವಿಕೆ", "ic_choking", "Critical",
            listOf(
                EmergencyStep(1, "Encourage coughing", "ಕೆಮ್ಮಲು ಪ್ರೋತ್ಸಾಹಿಸಿ", "If the person can cough forcefully, encourage them to keep coughing until the object is clear.", "ವ್ಯಕ್ತಿಯು ಬಲವಾಗಿ ಕೆಮ್ಮಲು ಸಾಧ್ಯವಾದರೆ, ವಸ್ತು ಹೊರಬರುವವರೆಗೆ ಕೆಮ್ಮಲು ಹೇಳಿ.", true, "ic_choking"),
                EmergencyStep(2, "5 Back Blows", "5 ಬೆನ್ನಿನ ಹೊಡೆತಗಳು", "Lean them forward and give 5 firm blows between the shoulder blades with the heel of your hand.", "ಅವರನ್ನು ಮುಂದೆ ಬಾಗಿಸಿ ನಿಮ್ಮ ಅಂಗೈ ಕೆಳಭಾಗದಿಂದ ಭುಜದ ಎಲುಬುಗಳ ಮಧ್ಯೆ 5 ಬಾರಿ ದೃಢವಾಗಿ ಹೊಡೆಯಿರಿ.", true, "ic_first_aid"),
                EmergencyStep(3, "5 Abdominal Thrusts", "5 ಹೊಟ್ಟೆಯ ಒತ್ತಡಗಳು", "Stand behind them, wrap arms around waist, and pull inward and upward above the navel.", "ಅವರ ಹಿಂದೆ ನಿಂತು, ಸೊಂಟದ ಸುತ್ತ ಕೈ ಹಾಕಿ, ಹೊಕ್ಕುಳದ ಮೇಲೆ ಒಳಕ್ಕೆ ಮತ್ತು ಮೇಲಕ್ಕೆ 5 ಬಾರಿ ಎಳೆಯಿರಿ.", true, "ic_first_aid"),
                EmergencyStep(4, "Repeat the cycle", "ಚಕ್ರವನ್ನು ಪುನರಾವರ್ತಿಸಿ", "Alternate between 5 back blows and 5 abdominal thrusts until the object is forced out.", "ವಸ್ತು ಹೊರಬರುವವರೆಗೆ 5 ಬೆನ್ನಿನ ಹೊಡೆತ ಮತ್ತು 5 ಹೊಟ್ಟೆಯ ಒತ್ತಡಗಳನ್ನು ಬದಲಿಸುತ್ತಾ ಮಾಡಿ.", true, "ic_first_aid"),
                EmergencyStep(5, "Call 108 if unconscious", "ಪ್ರಜ್ಞೆ ತಪ್ಪಿದರೆ 108 ಗೆ ಕರೆ ಮಾಡಿ", "If the person passes out, lower them to the floor and start CPR immediately.", "ವ್ಯಕ್ತಿ ಪ್ರಜ್ಞೆ ತಪ್ಪಿದರೆ, ಅವರನ್ನು ನೆಲದ ಮೇಲೆ ಮಲಗಿಸಿ ತಕ್ಷಣ ಸಿಪಿಆರ್ (CPR) ಪ್ರಾರಂಭಿಸಿ.", true, "ic_first_aid"),
                EmergencyStep(6, "No blind sweeps", "ಗೊತ್ತಿಲ್ಲದೆ ಕೈ ಹಾಕಬೇಡಿ", "Never put your fingers into their mouth to search for an object you cannot see clearly.", "ಸ್ಪಷ್ಟವಾಗಿ ಕಾಣದ ವಸ್ತುವಿಗಾಗಿ ಬಾಯಿಯೊಳಗೆ ಬೆರಳುಗಳನ್ನು ಹಾಕಬೇಡಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            4, "Fracture", "ಎಲುಬು ಮುರಿತ", "ic_fracture", "Medium",
            listOf(
                EmergencyStep(1, "Control bleeding", "ರಕ್ತಸ್ರಾವ ತಡೆಯಿರಿ", "Apply pressure to any bleeding wounds with a clean cloth before attending to the bone.", "ಎಲುಬಿನ ಕಡೆ ಗಮನ ಕೊಡುವ ಮೊದಲು ಯಾವುದೇ ರಕ್ತಸ್ರಾವವಿದ್ದರೆ ಸ್ವಚ್ಛ ಬಟ್ಟೆಯಿಂದ ಒತ್ತಿ ತಡೆಯಿರಿ.", true, "ic_bleeding"),
                EmergencyStep(2, "Immobilize the area", "ಭಾಗವನ್ನು ಚಲಿಸದಂತೆ ಇಡಿ", "Do not try to realign the bone. Keep the injured limb in the exact position you found it.", "ಎಲುಬನ್ನು ಸರಿಪಡಿಸಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ. ಗಾಯಗೊಂಡ ಭಾಗವನ್ನು ಇದ್ದ ಸ್ಥಿತಿಯಲ್ಲೇ ಚಲಿಸದಂತೆ ಇಡಿ.", true, "ic_fracture"),
                EmergencyStep(3, "Apply a splint", "ಆಸರೆ ನೀಡಿ (Splint)", "Use a stiff object (cardboard, stick) to support the joint above and below the fracture site.", "ಮುರಿತದ ಭಾಗದ ಮೇಲಿನ ಮತ್ತು ಕೆಳಗಿನ ಸಂಧಿಗೆ ಬೆಂಬಲ ನೀಡಲು ಗಟ್ಟಿಯಾದ ವಸ್ತುವನ್ನು (ಕಾರ್ಡ್‌ಬೋರ್ಡ್, ಕೋಲು) ಬಳಸಿ.", true, "ic_bandage"),
                EmergencyStep(4, "Cold compress", "ತಂಪು ಪ್ಯಾಕ್ ಹಚ್ಚಿ", "Apply an ice pack wrapped in a towel for 10 minutes to reduce pain and swelling.", "ನೋವು ಮತ್ತು ಊತ ಕಡಿಮೆ ಮಾಡಲು ಟವೆಲ್‌ನಲ್ಲಿ ಸುತ್ತಿದ ಐಸ್ ಪ್ಯಾಕ್ ಅನ್ನು 10 ನಿಮಿಷಗಳ ಕಾಲ ಇಡಿ.", true, "ic_cold"),
                EmergencyStep(5, "Check circulation", "ರಕ್ತ ಪರಿಚಲನೆ ಗಮನಿಸಿ", "Ensure bandages aren't too tight. Check if fingers or toes feel cold or look blue.", "ಬ್ಯಾಂಡೇಜ್ ತುಂಬಾ ಬಿಗಿಯಾಗಿಲ್ಲ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ. ಬೆರಳುಗಳು ತಣ್ಣಗಾಗಿದೆಯೇ ಅಥವಾ ನೀಲಿ ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿದೆಯೇ ನೋಡಿ.", true, "ic_bandage"),
                EmergencyStep(6, "Do not move the person", "ವ್ಯಕ್ತಿಯನ್ನು ಚಲಿಸಬೇಡಿ", "Avoid moving the person if a back or neck injury is suspected.", "ಬೆನ್ನು ಅಥವಾ ಕುತ್ತಿಗೆಗೆ ಗಾಯವಾಗಿದೆ ಎಂದು ಶಂಕೆಯಿದ್ದರೆ ವ್ಯಕ್ತಿಯನ್ನು ಚಲಿಸಬೇಡಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            5, "Seizure", "ಅಪಸ್ಮಾರ (ಫಿಟ್ಸ್)", "ic_seizure", "High",
            listOf(
                EmergencyStep(1, "Keep them safe", "ಸುರಕ್ಷಿತವಾಗಿರಿಸಿ", "Clear the area of hard or sharp objects to prevent the person from hurting themselves.", "ವ್ಯಕ್ತಿಗೆ ಪೆಟ್ಟಾಗದಂತೆ ಅವರ ಸುತ್ತಲಿರುವ ಗಟ್ಟಿಯಾದ ಅಥವಾ ಚೂಪಾದ ವಸ್ತುಗಳನ್ನು ದೂರ ಸರಿಸಿ.", true, "ic_seizure"),
                EmergencyStep(2, "Protect the head", "ತಲೆಗೆ ರಕ್ಷಣೆ ನೀಡಿ", "Place something soft, like a folded jacket, under their head.", "ತಲೆಯ ಕೆಳಗೆ ಮಡಿಸಿದ ಜ್ಯಾಕೆಟ್‌ನಂತಹ ಮೃದುವಾದ ವಸ್ತುವನ್ನು ಇಡಿ.", true, "ic_recovery"),
                EmergencyStep(3, "Time the seizure", "ಸಮಯ ಗಮನಿಸಿ", "Start timing the seizure. If it lasts more than 5 minutes, call 108 immediately.", "ಫಿಟ್ಸ್ ಪ್ರಾರಂಭವಾದ ಸಮಯ ನೋಡಿ. 5 ನಿಮಿಷಕ್ಕಿಂತ ಹೆಚ್ಚು ಕಾಲ ಮುಂದುವರಿದರೆ ತಕ್ಷಣ 108 ಗೆ ಕರೆ ಮಾಡಿ.", true, "ic_first_aid"),
                EmergencyStep(4, "Loosen ties/collars", "ಬಟ್ಟೆ ಸಡಿಲಗೊಳಿಸಿ", "Gently loosen anything around the neck that might make breathing difficult.", "ಉಸಿರಾಟಕ್ಕೆ ತೊಂದರೆಯಾಗುವಂತಹ ಕುತ್ತಿಗೆಯ ಸುತ್ತಲಿನ ಬಟ್ಟೆಗಳನ್ನು ನಿಧಾನವಾಗಿ ಸಡಿಲಗೊಳಿಸಿ.", true, "ic_bandage"),
                EmergencyStep(5, "The Recovery Position", "ಬದಿಗೆ ತಿರುಗಿಸಿ (Recovery)", "Once the shaking stops, gently turn them onto their side to keep the airway clear.", "ನಡುಕು ನಿಂತ ನಂತರ, ಉಸಿರಾಟದ ಹಾದಿ ಮುಕ್ತವಾಗಿಡಲು ಅವರನ್ನು ನಿಧಾನವಾಗಿ ಒಂದು ಬದಿಗೆ ತಿರುಗಿಸಿ ಮಲಗಿಸಿ.", true, "ic_recovery"),
                EmergencyStep(6, "Do not hold them down", "ಬಲವಂತವಾಗಿ ಹಿಡಿಯಬೇಡಿ", "Do not try to restrain their movements or stop the jerking.", "ವ್ಯಕ್ತಿಯ ಚಲನೆಯನ್ನು ಅಥವಾ ನಡುಕವನ್ನು ಬಲವಂತವಾಗಿ ತಡೆಯಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ.", false, "ic_warning"),
                EmergencyStep(7, "Nothing in mouth", "ಬಾಯಿಗೆ ಏನನ್ನೂ ಹಾಕಬೇಡಿ", "Do not put anything in the person's mouth. They will not swallow their tongue.", "ವ್ಯಕ್ತಿಯ ಬಾಯಿಗೆ ಏನನ್ನೂ ಹಾಕಬೇಡಿ. ಅವರು ತಮ್ಮ ನಾಲಿಗೆಯನ್ನು ನುಂಗುವುದಿಲ್ಲ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            6, "Cardiac Arrest", "ಹೃದಯಸ್ತಂಭನ", "ic_first_aid", "Critical",
            listOf(
                EmergencyStep(1, "Check response", "ಪ್ರತಿಕ್ರಿಯೆ ಪರಿಶೀಲಿಸಿ", "Tap the shoulders and shout to see if they wake up. Check for normal breathing.", "ವ್ಯಕ್ತಿಯನ್ನು ಎಚ್ಚರಿಸಲು ಭುಜ ತಟ್ಟಿ ಜೋರಾಗಿ ಕೂಗಿ. ಅವರು ಸಹಜವಾಗಿ ಉಸಿರಾಡುತ್ತಿದ್ದಾರೆಯೇ ಎಂದು ನೋಡಿ.", true, "ic_first_aid"),
                EmergencyStep(2, "Call 108 immediately", "ತಕ್ಷಣ 108 ಗೆ ಕರೆ ಮಾಡಿ", "Assign someone to call for an ambulance and find an AED if available.", "ಆಂಬ್ಯುಲೆನ್ಸ್‌ಗೆ ಕರೆ ಮಾಡಲು ಯಾರಿಗಾದರೂ ತಿಳಿಸಿ ಮತ್ತು ಎಇಡಿ (AED) ಸಾಧನ ಸಿಗುತ್ತದೆಯೇ ನೋಡಿ.", true, "ic_first_aid"),
                EmergencyStep(3, "Start CPR", "ಸಿಪಿಆರ್ (CPR) ಪ್ರಾರಂಭಿಸಿ", "Place hands in the center of the chest. Push hard and fast (100-120 beats per minute).", "ಎದೆಯ ಮಧ್ಯಭಾಗದಲ್ಲಿ ಕೈಗಳನ್ನಿಡಿ. ಎದೆಯನ್ನು ಗಟ್ಟಿಯಾಗಿ ಮತ್ತು ವೇಗವಾಗಿ ಒತ್ತಿರಿ (ನಿಮಿಷಕ್ಕೆ 100-120 ಬಾರಿ).", true, "ic_first_aid"),
                EmergencyStep(4, "Full chest recoil", "ಎದೆ ಮೇಲೆ ಬರಲು ಬಿಡಿ", "Allow the chest to return to its normal position after each push.", "ಪ್ರತಿ ಬಾರಿ ಒತ್ತಿದ ನಂತರ ಎದೆಯು ತನ್ನ ಸಹಜ ಸ್ಥಿತಿಗೆ ಬರಲು ಬಿಡಿ.", true, "ic_first_aid"),
                EmergencyStep(5, "Minimize interruptions", "ನಿಲ್ಲಿಸಬೇಡಿ", "Keep going until help arrives or the person starts moving. Do not pause for more than 10 seconds.", "ಸಹಾಯ ಬರುವವರೆಗೆ ಅಥವಾ ವ್ಯಕ್ತಿ ಚಲಿಸುವವರೆಗೆ ಮುಂದುವರಿಸಿ. 10 ಸೆಕೆಂಡ್‌ಗಿಂತ ಹೆಚ್ಚು ಕಾಲ ನಿಲ್ಲಿಸಬೇಡಿ.", true, "ic_first_aid"),
                EmergencyStep(6, "Do not give water", "ನೀರು ಕೊಡಬೇಡಿ", "Never attempt to give water or food to an unconscious person.", "ಪ್ರಜ್ಞೆ ಇಲ್ಲದ ವ್ಯಕ್ತಿಗೆ ಎಂದಿಗೂ ನೀರು ಅಥವಾ ಆಹಾರ ನೀಡಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            7, "Poisoning", "ವಿಷಪ್ರಾಶನ", "ic_warning", "Critical",
            listOf(
                EmergencyStep(1, "Assess the situation", "ಪರಿಸ್ಥಿತಿಯನ್ನು ಅವಲೋಕಿಸಿ", "Identify what was taken, how much, and when. Keep the container or label for doctors.", "ಏನು ಸೇವಿಸಲಾಗಿದೆ, ಎಷ್ಟು ಮತ್ತು ಯಾವಾಗ ಎಂದು ತಿಳಿಯಿರಿ. ವೈದ್ಯರಿಗಾಗಿ ಆ ಡಬ್ಬಿ ಅಥವಾ ಲೇಬಲ್ ಇಟ್ಟುಕೊಳ್ಳಿ.", true, "ic_warning"),
                EmergencyStep(2, "Skin or eye contact", "ಚರ್ಮ ಅಥವಾ ಕಣ್ಣಿನ ಸಂಪರ್ಕ", "If poison is on skin or in eyes, rinse with running water for at least 15 minutes.", "ವಿಷವು ಚರ್ಮ ಅಥವಾ ಕಣ್ಣಿನ ಮೇಲೆ ಬಿದ್ದಿದ್ದರೆ, ಕನಿಷ್ಠ 15 ನಿಮಿಷ ಹರಿಯುವ ನೀರಿನಲ್ಲಿ ತೊಳೆಯಿರಿ.", true, "ic_cold"),
                EmergencyStep(3, "Check breathing", "ಉಸಿರಾಟ ಗಮನಿಸಿ", "If the person stops breathing or feels very sleepy, call 108 immediately.", "ವ್ಯಕ್ತಿಯು ಉಸಿರಾಟ ನಿಲ್ಲಿಸಿದರೆ ಅಥವಾ ತುಂಬಾ ನಿದ್ರಾವಸ್ಥೆಯಲ್ಲಿದ್ದರೆ, ತಕ್ಷಣ 108 ಗೆ ಕರೆ ಮಾಡಿ.", true, "ic_first_aid"),
                EmergencyStep(4, "Stay with them", "ಜೊತೆಯಲ್ಲೇ ಇರಿ", "Keep the person calm and monitor their level of consciousness until help arrives.", "ಸಹಾಯ ಬರುವವರೆಗೆ ವ್ಯಕ್ತಿಯನ್ನು ಶಾಂತವಾಗಿರಿಸಿ ಮತ್ತು ಅವರ ಪ್ರಜ್ಞೆಯ ಮಟ್ಟವನ್ನು ಗಮನಿಸಿ.", true, "ic_recovery"),
                EmergencyStep(5, "Do not induce vomiting", "ವಾಂತಿ ಮಾಡಿಸಬೇಡಿ", "Inducing vomiting can cause more damage to the throat if the poison is corrosive.", "ವಿಷವು ತೀಕ್ಷ್ಣವಾಗಿದ್ದರೆ ವಾಂತಿ ಮಾಡಿಸುವುದು ಗಂಟಲಿಗೆ ಹೆಚ್ಚಿನ ಹಾನಿ ಉಂಟುಮಾಡಬಹುದು.", false, "ic_warning"),
                EmergencyStep(6, "No home remedies", "ಮನೆಮದ್ದು ಬೇಡ", "Do not give milk, oil, or salt water unless instructed by a medical professional.", "ವೈದ್ಯರು ಸೂಚಿಸದ ಹೊರತು ಹಾಲು, ಎಣ್ಣೆ ಅಥವಾ ಉಪ್ಪು ನೀರನ್ನು ನೀಡಬೇಡಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            8, "Heart Attack", "ಹೃದಯಾಘಾತ", "ic_first_aid", "Critical",
            listOf(
                EmergencyStep(1, "Call 108", "108 ಗೆ ಕರೆ ಮಾಡಿ", "Call immediately if the person has chest pain, shortness of breath, or cold sweats.", "ವ್ಯಕ್ತಿಗೆ ಎದೆನೋವು, ಉಸಿರಾಟದ ತೊಂದರೆ ಅಥವಾ ಶೀತದ ಬೆವರುವಿಕೆ ಇದ್ದರೆ ತಕ್ಷಣ ಕರೆ ಮಾಡಿ.", true, "ic_first_aid"),
                EmergencyStep(2, "Sit them down", "ಕುಳ್ಳಿರಿಸಿ", "Make them sit on the floor, leaning against a wall with knees bent to reduce heart strain.", "ಹೃದಯದ ಮೇಲಿನ ಒತ್ತಡ ಕಡಿಮೆ ಮಾಡಲು ಗೋಡೆಗೆ ಒರಗಿಸಿ, ಮೊಣಕಾಲು ಮಡಚಿ ನೆಲದ ಮೇಲೆ ಕುಳ್ಳಿರಿಸಿ.", true, "ic_recovery"),
                EmergencyStep(3, "Aspirin if advised", "ಸೂಚಿಸಿದರೆ ಆಸ್ಪಿರಿನ್ ನೀಡಿ", "If they have a 300mg aspirin and are not allergic, ask them to chew it slowly.", "ಅವರ ಬಳಿ 300mg ಆಸ್ಪಿರಿನ್ ಇದ್ದರೆ ಮತ್ತು ಅಲರ್ಜಿ ಇಲ್ಲದಿದ್ದರೆ, ಅದನ್ನು ನಿಧಾನವಾಗಿ ಅಗಿಯಲು ಹೇಳಿ.", true, "ic_first_aid"),
                EmergencyStep(4, "Loosen tight clothes", "ಬಟ್ಟೆ ಸಡಿಲಗೊಳಿಸಿ", "Unbutton the shirt collar or loosen belts to help them breathe more easily.", "ಸುಲಭವಾಗಿ ಉಸಿರಾಡಲು ಶರ್ಟ್ ಕಾಲರ್ ಅಥವಾ ಬೆಲ್ಟ್ ಅನ್ನು ಸಡಿಲಗೊಳಿಸಿ.", true, "ic_bandage"),
                EmergencyStep(5, "Stay calm", "ಶಾಂತವಾಗಿರಿ", "Reassure the person and stay with them. Anxiety can worsen heart symptoms.", "ವ್ಯಕ್ತಿಗೆ ಧೈರ್ಯ ತುಂಬಿ ಮತ್ತು ಅವರ ಜೊತೆಯಲ್ಲೇ ಇರಿ. ಆತಂಕವು ಹೃದಯದ ಲಕ್ಷಣಗಳನ್ನು ಉಲ್ಬಣಗೊಳಿಸಬಹುದು.", true, "ic_recovery"),
                EmergencyStep(6, "Do not drive", "ವಾಹನ ಚಲಾಯಿಸಬೇಡಿ", "Do not let the person drive themselves to the hospital. Wait for the ambulance.", "ವ್ಯಕ್ತಿಯನ್ನು ತಾನೇ ವಾಹನ ಚಲಾಯಿಸಿ ಆಸ್ಪತ್ರೆಗೆ ಹೋಗಲು ಬಿಡಬೇಡಿ. ಆಂಬ್ಯುಲೆನ್ಸ್‌ಗಾಗಿ ಕಾಯಿರಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            9, "Stroke", "ಪಾರ್ಶ್ವವಾಯು (ಬ್ರೈನ್ ಅಟ್ಯಾಕ್)", "ic_warning", "Critical",
            listOf(
                EmergencyStep(1, "Check Face", "ಮುಖ ಗಮನಿಸಿ", "Ask the person to smile. Does one side of the face droop?", "ವ್ಯಕ್ತಿಯನ್ನು ನಗಲು ಹೇಳಿ. ಮುಖದ ಒಂದು ಬದಿ ಕೆಳಗೆ ವಾಲುತಿದೆಯೇ?", true, "ic_warning"),
                EmergencyStep(2, "Check Arms", "ಕೈಗಳನ್ನು ಗಮನಿಸಿ", "Ask them to raise both arms. Does one arm drift downward?", "ಅವರನ್ನು ಎರಡೂ ಕೈ ಎತ್ತಲು ಹೇಳಿ. ಒಂದು ಕೈ ಕೆಳಗೆ ಸರಿಯುತ್ತಿದೆಯೇ?", true, "ic_warning"),
                EmergencyStep(3, "Check Speech", "ಮಾತನ್ನು ಗಮನಿಸಿ", "Ask them to repeat a simple sentence. Is their speech slurred or strange?", "ಒಂದು ಸಣ್ಣ ವಾಕ್ಯ ಹೇಳಲು ಹೇಳಿ. ಅವರ ಮಾತು ತೊದಲುತ್ತಿದೆಯೇ ಅಥವಾ ವಿಚಿತ್ರವಾಗಿದೆಯೇ?", true, "ic_warning"),
                EmergencyStep(4, "Time to call 108", "108 ಗೆ ಕರೆ ಮಾಡುವ ಸಮಯ", "If you see any of these signs, call for emergency help immediately.", "ಈ ಯಾವುದೇ ಲಕ್ಷಣಗಳು ಕಂಡರೂ ತಕ್ಷಣ ತುರ್ತು ಸಹಾಯಕ್ಕೆ ಕರೆ ಮಾಡಿ.", true, "ic_first_aid"),
                EmergencyStep(5, "Position for comfort", "ಆರಾಮವಾಗಿಡಿ", "Lay them down on their side to prevent choking if they vomit.", "ವಾಂತಿಯಾದರೆ ಉಸಿರುಕಟ್ಟದಂತೆ ತಡೆಯಲು ಅವರನ್ನು ಒಂದು ಬದಿಗೆ ಮಲಗಿಸಿ.", true, "ic_recovery"),
                EmergencyStep(6, "Do not give meds", "ಔಷಧಿ ನೀಡಬೇಡಿ", "Do not give aspirin or any other medicine as the stroke could be a brain bleed.", "ಪಾರ್ಶ್ವವಾಯು ಮೆದುಳಿನ ರಕ್ತಸ್ರಾವದಿಂದಲೂ ಇರಬಹುದು, ಆದ್ದರಿಂದ ಆಸ್ಪಿರಿನ್ ಅಥವಾ ಬೇರೆ ಔಷಧಿ ನೀಡಬೇಡಿ.", false, "ic_warning")
            )
        ),
        EmergencyCase(
            10, "Heat Stroke", "ಬಿಸಿಲ ಬೇಗೆ (ಸನ್ ಸ್ಟ್ರೋಕ್)", "ic_cold", "High",
            listOf(
                EmergencyStep(1, "Move to cool area", "ತಂಪಾದ ಜಾಗಕ್ಕೆ ಕರೆದೊಯ್ಯಿರಿ", "Immediately move the person out of the sun and into a shaded or air-conditioned room.", "ತಕ್ಷಣ ವ್ಯಕ್ತಿಯನ್ನು ಬಿಸಿಲಿನಿಂದ ಹೊರಗೆ ತಂದು ನೆರಳು ಅಥವಾ ಎಸಿ ಇರುವ ಕೋಣೆಗೆ ಕರೆದೊಯ್ಯಿರಿ.", true, "ic_recovery"),
                EmergencyStep(2, "Rapid cooling", "ವೇಗವಾಗಿ ತಂಪಾಗಿಸಿ", "Spray them with cool water and use a fan to blow air across them.", "ತಣ್ಣೀರು ಸಿಂಪಡಿಸಿ ಮತ್ತು ಅವರ ಮೇಲೆ ಗಾಳಿ ಬೀಸಲು ಫ್ಯಾನ್ ಬಳಸಿ.", true, "ic_cold"),
                EmergencyStep(3, "Apply wet packs", "ಒದ್ದೆ ಪ್ಯಾಕ್ ಇಡಿ", "Place cold, wet cloths or ice packs on the neck, armpits, and groin areas.", "ಕುತ್ತಿಗೆ, ಬಗಲು ಮತ್ತು ತೊಡೆಸಂದಿ ಭಾಗಗಳಲ್ಲಿ ತಣ್ಣನೆಯ ಒದ್ದೆ ಬಟ್ಟೆ ಅಥವಾ ಐಸ್ ಪ್ಯಾಕ್ ಇಡಿ.", true, "ic_cold"),
                EmergencyStep(4, "Assess consciousness", "ಪ್ರಜ್ಞೆ ಗಮನಿಸಿ", "Check if they are confused, agitated, or lose consciousness. These are signs of heat stroke.", "ಅವರು ಗೊಂದಲಕ್ಕೊಳಗಾಗಿದ್ದಾರೆಯೇ ಅಥವಾ ಪ್ರಜ್ಞೆ ತಪ್ಪಿದ್ದಾರೆಯೇ ಗಮನಿಸಿ. ಇವು ಸನ್ ಸ್ಟ್ರೋಕ್‌ನ ಲಕ್ಷಣಗಳು.", true, "ic_first_aid"),
                EmergencyStep(5, "No hot drinks", "ಬಿಸಿ ಪಾನೀಯ ಬೇಡ", "Avoid giving them any hot drinks or alcohol.", "ಅವರಿಗೆ ಯಾವುದೇ ಬಿಸಿ ಪಾನೀಯ ಅಥವಾ ಮದ್ಯವನ್ನು ನೀಡಬೇಡಿ.", false, "ic_warning"),
                EmergencyStep(6, "Small sips only", "ಸಣ್ಣ ಹನಿಗಳನ್ನಷ್ಟೇ ನೀಡಿ", "If they are alert, give small sips of cool water. Do not force them to drink fast.", "ಅವರು ಪ್ರಜ್ಞೆಯಲ್ಲಿದ್ದರೆ ತಣ್ಣೀರನ್ನು ಸ್ವಲ್ಪ ಸ್ವಲ್ಪವೇ ನೀಡಿ. ವೇಗವಾಗಿ ಕುಡಿಯಲು ಒತ್ತಾಯಿಸಬೇಡಿ.", true, "ic_cold")
            )
        ),
        EmergencyCase(
            11, "Animal Bite", "ಪ್ರಾಣಿ ಕಡಿತ (ನಾಯಿ/ಹಾವು)", "ic_warning", "High",
            listOf(
                EmergencyStep(1, "Secure the area", "ಜಾಗ ಸುರಕ್ಷಿತಗೊಳಿಸಿ", "Ensure the animal is gone and you are in a safe place before starting treatment.", "ಚಿಕಿತ್ಸೆ ಪ್ರಾರಂಭಿಸುವ ಮೊದಲು ಪ್ರಾಣಿ ದೂರ ಹೋಗಿದೆಯೇ ಮತ್ತು ನೀವು ಸುರಕ್ಷಿತ ಜಾಗದಲ್ಲಿದ್ದೀರಾ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ.", true, "ic_recovery"),
                EmergencyStep(2, "Flush with water", "ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ", "For a dog or animal bite, wash with soap and running water for at least 15 minutes.", "ನಾಯಿ ಅಥವಾ ಇತರ ಪ್ರಾಣಿ ಕಡಿತಕ್ಕೊಳಗಾದ ಜಾಗವನ್ನು ಸೋಪು ಮತ್ತು ಹರಿಯುವ ನೀರಿನಲ್ಲಿ ಕನಿಷ್ಠ 15 ನಿಮಿಷ ತೊಳೆಯಿರಿ.", true, "ic_cold"),
                EmergencyStep(3, "Snake bite: Keep still", "ಹಾವು ಕಡಿತ: ಚಲಿಸಬೇಡಿ", "Keep the bitten limb below the heart level and avoid any movement to slow venom spread.", "ವಿಷ ಹರಡುವುದನ್ನು ತಡೆಯಲು ಕಡಿತಕ್ಕೊಳಗಾದ ಅಂಗವನ್ನು ಹೃದಯದ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗಿಡಿ ಮತ್ತು ಚಲಿಸಬೇಡಿ.", true, "ic_fracture"),
                EmergencyStep(4, "Cover loosely", "ಸಡಿಲವಾಗಿ ಮುಚ್ಚಿ", "Apply a clean, dry bandage or cloth over the bite site.", "ಕಡಿತದ ಜಾಗದ ಮೇಲೆ ಸ್ವಚ್ಛವಾದ, ಒಣ ಬ್ಯಾಂಡೇಜ್ ಅಥವಾ ಬಟ್ಟೆಯನ್ನು ಇಡಿ.", true, "ic_bandage"),
                EmergencyStep(5, "Do not tourniquet", "ಬಿಗಿಯಾಗಿ ಕಟ್ಟಬೇಡಿ (Tourniquet)", "Do not use a tight band or tourniquet, as this can cause permanent tissue damage.", "ಬಿಗಿಯಾದ ಪಟ್ಟಿ ಅಥವಾ ಟೂರ್ನಿಕೆಟ್ ಬಳಸಬೇಡಿ, ಇದು ಕಾಯಂ ಅಂಗಾಂಶ ಹಾನಿಗೆ ಕಾರಣವಾಗಬಹುದು.", false, "ic_warning"),
                EmergencyStep(6, "Do not cut the wound", "ಗಾಯ ಕತ್ತರಿಸಬೇಡಿ", "Never try to cut the bite area or use chemicals on it.", "ಕಡಿತದ ಜಾಗವನ್ನು ಕತ್ತರಿಸಲು ಅಥವಾ ಅಲ್ಲಿ ರಾಸಾಯನಿಕಗಳನ್ನು ಬಳಸಲು ಎಂದಿಗೂ ಪ್ರಯತ್ನಿಸಬೇಡಿ.", false, "ic_warning")
            )
        )
    )

    val hospitals: List<Hospital> = listOf(
        Hospital(1, "Govt. Meggan Hospital", "ಸರ್ಕಾರಿ ಮೆಗ್ಗಾನ್ ಆಸ್ಪತ್ರೆ", 0.0, "08182-271566", "Sagar Road, Shivamogga", "ಸಾಗರ ರಸ್ತೆ, ಶಿವಮೊಗ್ಗ", 13.9347, 75.5646),
        Hospital(2, "Nanjappa Multi-Specialty Hospital", "ನಂಜಪ್ಪ ಮಲ್ಟಿ-ಸ್ಪೆಷಾಲಿಟಿ ಆಸ್ಪತ್ರೆ", 0.0, "08182-267300", "Kuvempu Road, Durgigudi, Shivamogga", "ಕುವೆಂಪು ರಸ್ತೆ, ದುರ್ಗಿ ಗುಡಿ, ಶಿವಮೊಗ್ಗ", 13.9387, 75.5715),
        Hospital(3, "Sahyadri Narayana Multispeciality", "ಸಹ್ಯಾದ್ರಿ ನಾರಾಯಣ ಮಲ್ಟಿ-ಸ್ಪೆಷಾಲಿಟಿ", 0.0, "08182-221588", "N T Road, Harakere, Shivamogga", "ಎನ್ ಟಿ ರಸ್ತೆ, ಹರಕೆರೆ, ಶಿವಮೊಗ್ಗ", 13.9180, 75.5850),
        Hospital(4, "Sarji Hospital", "ಸರ್ಜಿ ಆಸ್ಪತ್ರೆ", 0.0, "08182-405505", "R.M.R. Road, Park Extension, Shivamogga", "ಆರ್‌ಎಂಆರ್ ರಸ್ತೆ, ಪಾರ್ಕ್ ಬಡಾವಣೆ, ಶಿವಮೊಗ್ಗ", 13.9360, 75.5720),
        Hospital(5, "Metro Hospital", "ಮೆಟ್ರೋ ಆಸ್ಪತ್ರೆ", 0.0, "078292-90303", "Savalanga Road, Jayanagar, Shivamogga", "ಸವಳಂಗ ರಸ್ತೆ, ಜಯನಗರ, ಶಿವಮೊಗ್ಗ", 13.9400, 75.5747),
        Hospital(6, "Max Hospital (MaAx)", "ಮ್ಯಾಕ್ಸ್ ಆಸ್ಪತ್ರೆ", 0.0, "08182-269400", "RMR Road, Durgigudi, Shivamogga", "ಆರ್‌ಎಂಆರ್ ರಸ್ತೆ, ದುರ್ಗಿ ಗುಡಿ, ಶಿವಮೊಗ್ಗ", 13.9358, 75.5711),
        Hospital(7, "Usha Nursing Home", "ಉಷಾ ನರ್ಸಿಂಗ್ ಹೋಮ್", 0.0, "08182-221955", "Savalanga Road, Ravindra Nagar, Shivamogga", "ಸವಳಂಗ ರಸ್ತೆ, ರವೀಂದ್ರ ನಗರ, ಶಿವಮೊಗ್ಗ", 13.9456, 75.5741),
        Hospital(8, "Ashoka Sanjeevini Hospital", "ಅಶೋಕ ಸಂಜೀವಿನಿ ಆಸ್ಪತ್ರೆ", 0.0, "08182-404555", "B.H. Road, Shivamogga", "ಬಿ ಎಚ್ ರಸ್ತೆ, ಶಿವಮೊಗ್ಗ", 13.9280, 75.5650),
        Hospital(9, "Chandragiri Multispeciality", "ಚಂದ್ರಗಿರಿ ಮಲ್ಟಿ-ಸ್ಪೆಷಾಲಿಟಿ", 0.0, "08182-220022", "Savalanga Road, Shivamogga", "ಸವಳಂಗ ರಸ್ತೆ, ಶಿವಮೊಗ್ಗ", 13.9460, 75.5750),
        Hospital(10, "Sri Basaveshwara Hospital", "ಶ್ರೀ ಬಸವೇಶ್ವರ ಆಸ್ಪತ್ರೆ", 0.0, "08182-406906", "Tilak Nagar, Shivamogga", "ತಿಲಕ್ ನಗರ, ಶಿವಮೊಗ್ಗ", 13.9385, 75.5705),
        Hospital(11, "City Hospital", "ಸಿಟಿ ಆಸ್ಪತ್ರೆ", 0.0, "08182-279137", "R.M.R. Road, Durgigudi, Shivamogga", "ಆರ್‌ಎಂಆರ್ ರಸ್ತೆ, ದುರ್ಗಿ ಗುಡಿ, ಶಿವಮೊಗ್ಗ", 13.9355, 75.5715),
        Hospital(12, "Unity Children’s Hospital", "ಯೂನಿಟಿ ಮಕ್ಕಳ ಆಸ್ಪತ್ರೆ", 0.0, "08182-274044", "Kuvempu Road, Shivamogga", "ಕುವೆಂಪು ರಸ್ತೆ, ಶಿವಮೊಗ್ಗ", 13.9335, 75.5655),
        Hospital(13, "Sankara Eye Hospital", "ಶಂಕರ ಕಣ್ಣಿನ ಆಸ್ಪತ್ರೆ", 0.0, "08182-222099", "Old Tirthahalli Road, Shivamogga", "ಹಳೆಯ ತೀರ್ಥಹಳ್ಳಿ ರಸ್ತೆ, ಶಿವಮೊಗ್ಗ", 13.9270, 75.5450)
    )

    fun caseById(id: Int): EmergencyCase? = cases.firstOrNull { it.id == id }
}
