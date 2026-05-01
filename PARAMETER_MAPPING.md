# MindPulsePro Parameter Mapping

This is the canonical mapping reference for implementation logic.

- Internal IDs (`P01...P92`, `Q01...Q08`) stay stable for engineering.
- Customer-facing UI always uses professional display names.
- Never expose internal IDs in customer UI.

## Mapping

| Internal ID | Professional Display Name |
|---|---|
| P01 | Heart Rate |
| P02 | Heart Rate Variability (RMSSD) |
| P03 | Physiological Stress Index |
| P04 | Recovery Readiness Score |
| P05 | Peripheral Skin Temperature |
| P06 | Physiological Activity Index |
| P07 | Signal Quality Score |
| P08 | Insight Confidence Score |
| P09 | Live Heart Rate |
| P10 | Inter-Beat Interval |
| P11 | Respiration Rate |
| P12 | Respiration Variability |
| P13 | Motion Intensity |
| P14 | Postural Stability |
| P15 | PPG Contact Quality |
| P16 | Data Stability Score |
| P17 | Recovery Readiness |
| P18 | Autonomic Balance Ratio |
| P19 | Overnight Heart Rate Drop |
| P20 | Overnight HRV Gain |
| P21 | Resting Heart Rate Deviation |
| P22 | Recovery Debt |
| P23 | Load Tolerance |
| P24 | Inflammatory Strain Proxy |
| P25 | Thermal Recovery Drift |
| P26 | Recovery Confidence |
| P27 | Acute Stress Load |
| P28 | Chronic Stress Burden |
| P29 | Sympathetic Dominance |
| P30 | Parasympathetic Recovery Tone |
| P31 | Arousal Volatility |
| P32 | Emotional Valence |
| P33 | Emotional Regulation |
| P34 | Trigger Sensitivity |
| P35 | Stress Recovery Latency |
| P36 | Cortical Arousal Proxy |
| P37 | Mood Stability |
| P38 | Stress Confidence |
| P39 | Cognitive Load |
| P40 | Sustained Attention |
| P41 | Mental Fatigue |
| P42 | Task Switching Cost |
| P43 | Processing Stability |
| P44 | Attention Drift |
| P45 | Cognitive Recovery |
| P46 | Neuro-Cardiac Coupling |
| P47 | Focus Readiness |
| P48 | Focus Confidence |
| P49 | Sleep Duration |
| P50 | Sleep Efficiency |
| P51 | Sleep Onset Latency |
| P52 | Wake After Sleep Onset |
| P53 | Deep Sleep Proportion |
| P54 | REM Sleep Proportion |
| P55 | Light Sleep Proportion |
| P56 | Sleep Fragmentation Rate |
| P57 | Overnight Respiration Rate |
| P58 | Nocturnal HRV |
| P59 | Sleep Recovery Contribution |
| P60 | Sleep Confidence |
| P61 | Cardiorespiratory Capacity |
| P62 | Submaximal Heart Rate Recovery |
| P63 | Lactate Threshold Proxy |
| P64 | Training Strain |
| P65 | Strain Tolerance |
| P66 | Muscular Recovery Index |
| P67 | Work Capacity Trend |
| P68 | Aerobic Efficiency |
| P69 | Anaerobic Response Index |
| P70 | Fitness Confidence |
| P71 | Metabolic Rate Proxy |
| P72 | Substrate Utilization |
| P73 | Glycemic Variability Proxy |
| P74 | Insulin Response Proxy |
| P75 | Thermic Load |
| P76 | Hydration Stress |
| P77 | Energy Stability |
| P78 | Metabolic Flexibility |
| P79 | Glucose Recovery Proxy |
| P80 | Metabolic Confidence |
| P81 | Biological Age Estimate |
| P82 | Chronological Age Delta |
| P83 | Cardiac Age Component |
| P84 | Autonomic Age Component |
| P85 | Recovery Age Component |
| P86 | Metabolic Age Component |
| P87 | Age Trajectory |
| P88 | Biological Age Confidence |
| P89 | Cycle Phase Confidence |
| P90 | Hormonal Transition Load |
| P91 | Cycle Recovery Variance |
| P92 | Symptom Burden Index |
| Q01 | Wear Detection Status |
| Q02 | Wear Confidence |
| Q03 | Signal Reliability |
| Q04 | BLE Signal Strength |
| Q05 | BLE Link Stability |
| Q06 | Battery Level |
| Q07 | Sync Latency |
| Q08 | Data Source Integrity |

## Implementation Note

- When you add a parameter registry in code, mirror this table as the customer-facing name source (stable internal IDs stay `P01…P92`, `Q01…Q08`).
- Current app sources live under `app/src/main/java/com/mindpulse/app/`.
- Keep this file synchronized whenever names are updated.
