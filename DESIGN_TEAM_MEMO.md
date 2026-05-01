# Design Team Memo: Deeper Implementation of PhysioCognitive Intelligence

Owner: Founder  
Audience: Design, UX/UI Research, Engineering

This product is an interpretive intelligence layer, not a tracker.  
Every visual element must map to traceable physiological signal logic.

## 1) Core Visual Architecture: Diagnostic vs Descriptive Duality

- **Dark Diagnostic Mode (Sensory/Lab)**
  - Purpose: raw, high-fidelity signal acquisition and validation.
  - Visual base: deep navy/charcoal.
  - Signal semantics:
    - ECG = Aqua
    - EEG = Lime
    - GSR = Crimson

- **Light Insight Mode (Descriptive/Journal)**
  - Purpose: validated interpretation, cognitive workouts, trend understanding.
  - Visual base: bone-white.
  - Accent family: sage and lavender.

## 2) Chart Fidelity Test

Charts must look publication-ready and clinically credible.

### 2a) Raw signal rendering (Bio-Stream)

- Real-time low-latency rendering (not decorative animation).
- EEG: multi-band representation (alpha/beta/theta) as stacked or composite lines.
- ECG: waveform + derived HRV/system harmony reference.
- GSR: independent channel in same diagnostic pane.
- Use translucent density overlays behind line work to indicate signal density.

### 2b) Aggregated data rendering

- Prefer chart hybrids over basic bars where possible:
  - column = total load
  - trend line = velocity/change direction
- Gauges use green→amber→red continuum with strict semantics.

## 3) The "So What?" Layer

Every insight must connect evidence to meaning to action.

### 3a) Validated Insight Card

Required chain:

`Observed raw signals + aggregated metrics -> interpreted state -> validated action`

Must include:

- Natural-language interpretation
- Action recommendation
- Traceability affordance (e.g., "Source Data") linking to diagnostic view

### 3b) Cognitive load mapping

- Use abstract neural map / node graph metaphors.
- Node state is dynamic:
  - cool/green-blue nodes = stronger function
  - amber/red nodes = overload/strain
- "Sync Now" diagnostic map must agree with focus-state map.

## 4) Transparency & Trust Architecture

### 4a) Data Fidelity Panel (dark diagnostic style)

Must expose:

- Composite Data Fidelity score (e.g., 9.8/10)
- Per-sensor status (green/amber/red)
- Data consistency (valid vs corrupt packet indication)
- Latency (real-time processing reinforcement)

### 4b) Transparency Log

- Timestamped technical audit entries
- Explicit biological reason chain for state changes
- Example:
  - `[14:32] Focus decreased due to elevated GSR and reduced EEG alpha power; corrected by adaptive filter.`

## 5) Screen Type Checklist

- **Raw Data (Diagnostic)**
  - multi-stream Bio-Stream
  - fidelity diagnostics
  - transparency log
  - dark mode

- **Insights (Descriptive)**
  - plain-language insight output
  - gauges and recommendation cards
  - correlation visuals
  - light mode

- **Cognitive Training**
  - interactive attention/endurance/recognition controls
  - tactile controls
  - controlled expressive visual cues

- **Profile/Journal**
  - modular cards
  - tagged narrative entries
  - optional leaderboard/community layer

## Engineering Guardrails

- Internal parameter IDs remain canonical (`Pxx`, `Qxx`).
- Customer UI always uses professional names.
- Any insight text must be derivable from source metrics.
- No black-box claims without evidence linkage.
