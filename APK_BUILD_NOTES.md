# MindPulsePro APK Build Notes

Use this protocol whenever the user asks to build an APK.

## APK output and naming

- Store all APK artifacts in: `F:\Senthority-MindPulse\APKs`
- APK names must follow versioned sequence:
  - `MindPulseProV1`
  - `MindPulseProV2`
  - `MindPulseProV3`
  - ...and so on.

## Mandatory pre-build validation

- Before every APK build, run a full validation pass:
  - syntax checks
  - logical error checks
  - ideation/self-loop checks

## Vision alignment gate

- Before every APK build, verify the current app is aligned to the MindPulsePro vision:
  - scientific calm interface
  - physiological intelligence focus (not fitness-app behavior)
  - trust/transparency indicators
  - layered insights and 92-parameter scientific depth

## Git + change log protocol (for each build cycle)

- Every time:
  - push latest code to remote (`git push`)
  - maintain a serious markdown log entry in bullet points containing:
    - what user asked
    - what changed
    - what was added
    - what was removed

Suggested running log file: `BUILD_CHANGELOG.md`
