# MindPulsePro Copy Style Guide

This guide standardizes UI copy across all screens so tone, clarity, and trust remain consistent.

## 1) Brand Voice

- Calm
- Scientific
- Reassuring
- Transparent
- Human-centered

MindPulsePro copy must feel like a precision health system that genuinely cares about physical and psychological wellbeing.

## 2) Tone Rules

- Prefer measured, confidence-building language.
- Be informative without sounding mechanical.
- Be supportive without sounding casual or playful.
- Explain uncertainty clearly when confidence is low.
- Never blame users for data issues.

## 3) Tense and Person

- Use present tense by default.
  - Example: `Signal is stabilizing.`
- Use second person sparingly and respectfully.
  - Preferred: `Your baseline is building.`
- Avoid future-heavy promises unless certainty is high.

## 4) Screen Care Statements (4-5 words)

Each primary screen must display one short care statement between 4 and 5 words.

### Required qualities

- Human and reassuring
- Physical + psychological wellbeing oriented
- Plain language
- No jargon

### Approved examples

- `Your wellbeing matters, always.`
- `Caring for body and mind.`
- `Supporting emotional balance, gently.`
- `Protecting cognitive clarity daily.`
- `Better rest, healthier days.`
- `Performance guided by wellbeing.`
- `Energy insights for resilience.`
- `Long-term vitality, thoughtfully measured.`
- `Personal rhythms, deeply respected.`
- `Reliable care through transparent signals.`

## 5) Microcopy Principles

- Prefer guidance over alarm:
  - `Stabilizing signal`
  - `Improving accuracy`
  - `Collecting baseline`
  - `Updating`
- Avoid abrupt failure language:
  - `Error`
  - `Failure`
  - `Unknown problem`
  - `No data available`

## 6) Confidence and Uncertainty Language

When model certainty is not high:

- state what is known
- state what is being validated
- state what user can do next

Pattern:
- `Current signal is improving. Confidence is moderate. Keep band contact steady.`

## 7) Parameter Explanation Standard

Every parameter should include a one-line explanation that is:

- 8 to 16 words
- plain-language first
- scientifically accurate
- free of marketing adjectives

Good:
- `Beat-to-beat variability indicating short-term autonomic regulation.`

Avoid:
- `Amazing metric for your awesome performance and wellness.`

## 8) Vocabulary Guardrails

### Preferred words

- baseline
- confidence
- signal quality
- validated
- trend
- stability
- recovery
- regulation
- readiness
- insight

### Words to minimize

- optimize
- hack
- boost
- crush
- elite
- perfect

## 9) Formatting Rules

- Keep UI lines concise.
- Prefer sentence case.
- Use numerals for metrics and units.
- Keep punctuation minimal; one period max in short helper text.
- Do not use emoji in product copy.

## 10) Copy Review Checklist (Before Merge)

- [ ] Tone is calm, scientific, and supportive.
- [ ] Screen care statement is 4-5 words.
- [ ] Message aligns with physical + psychological wellbeing.
- [ ] Uncertainty is transparent where relevant.
- [ ] No alarmist or gamified fitness language.
- [ ] Parameter explanation is plain-language and accurate.

## 11) Ownership and Updates

- Update this file whenever new screens or message patterns are added.
- Keep examples synced with live UI in `MainActivity.kt` (and later split UI modules).
