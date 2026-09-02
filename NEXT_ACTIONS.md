# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 40/40 (100.0%)
- **Function parity:** 12/13 matched (target 67) — 92.3%
- **Class/type parity:** 267/267 matched (target 283) — 100.0%
- **Combined symbol parity:** 279/280 matched (target 350) — 99.6%
- **Average inline-code cosine:** 0.04 (function body across 40 matched files)
- **Average documentation cosine:** 0.00 (doc text across 40 matched files)
- **Cheat-zeroed Files:** 38
- **Critical Issues:** 39 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. base

- **Target:** `base.Base [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 13910.0
- **Functions:** 3/4 matched
- **Missing functions:** `as_void_ptr`
- **Types:** 35/35 matched (target 42)
- **Missing types:** _none_

### 2. xml_node

- **Target:** `xmlnode.XmlNode [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1610.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 16/16 matched
- **Missing types:** _none_

### 3. runloop

- **Target:** `runloop.Runloop [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1510.0
- **Functions:** 0/0 matched (target 4)
- **Missing functions:** _none_
- **Types:** 15/15 matched
- **Missing types:** _none_

### 4. xml_parser

- **Target:** `xmlparser.XmlParser [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 14/14 matched
- **Missing types:** _none_

### 5. stream

- **Target:** `stream.Stream [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1210.0
- **Functions:** 0/0 matched (target 2)
- **Missing functions:** _none_
- **Types:** 12/12 matched (target 13)
- **Missing types:** _none_

### 6. dictionary

- **Target:** `dictionary.Dictionary [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1110.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 11/11 matched
- **Missing types:** _none_

### 7. bag

- **Target:** `bag.Bag [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1010.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 10/10 matched
- **Missing types:** _none_

### 8. set

- **Target:** `set.Set [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1010.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 10/10 matched
- **Missing types:** _none_

### 9. array

- **Target:** `array.Array [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 910.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 9/9 matched
- **Missing types:** _none_

### 10. url

- **Target:** `url.Urls [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 810.0
- **Functions:** 1/1 matched (target 2)
- **Missing functions:** _none_
- **Types:** 7/7 matched (target 8)
- **Missing types:** _none_
- **Tests:** 1/1 matched

### 11. bundle

- **Target:** `bundle.Bundle [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 810.0
- **Functions:** 4/4 matched (target 5)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 12. socket

- **Target:** `socket.Socket [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 810.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 8/8 matched
- **Missing types:** _none_

### 13. tree

- **Target:** `tree.Tree [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 710.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 7/7 matched
- **Missing types:** _none_

### 14. number_formatter

- **Target:** `numberformatter.NumberFormatter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 710.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 7/7 matched
- **Missing types:** _none_

### 15. plugin

- **Target:** `plugin.PlugIn [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 710.0
- **Functions:** 0/0 matched (target 2)
- **Missing functions:** _none_
- **Types:** 7/7 matched (target 8)
- **Missing types:** _none_

### 16. string

- **Target:** `string.Strings [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 710.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 7/7 matched
- **Missing types:** _none_

### 17. locale

- **Target:** `locale.Locale [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 610.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 6/6 matched
- **Missing types:** _none_

### 18. number

- **Target:** `number.Numbers [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 610.0
- **Functions:** 1/1 matched (target 3)
- **Missing functions:** _none_
- **Types:** 5/5 matched (target 7)
- **Missing types:** _none_
- **Tests:** 1/1 matched

### 19. user_notification

- **Target:** `usernotification.UserNotification`
- **Similarity:** 0.58
- **Dependents:** 0
- **Priority Score:** 604.2
- **Functions:** 3/3 matched (target 4)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 20. date_formatter

- **Target:** `dateformatter.DateFormatter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 21. notification_center

- **Target:** `notificationcenter.NotificationCenter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 22. filedescriptor

- **Target:** `filedescriptor.FileDescriptor [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 23. mach_port

- **Target:** `machport.MachPort [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 24. binary_heap

- **Target:** `binaryheap.BinaryHeap [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 25. messageport

- **Target:** `messageport.MessagePort [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 510.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 5/5 matched
- **Missing types:** _none_

### 26. date

- **Target:** `date.Dates [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 27. bit_vector

- **Target:** `bitvector.BitVector [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 28. data

- **Target:** `data.Data [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 29. url_enumerator

- **Target:** `urlenumerator.UrlEnumerator [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 30. characterset

- **Target:** `characterset.Characterset [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 4/4 matched
- **Missing types:** _none_

### 31. calendar

- **Target:** `calendar.Calendar [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 32. file_security

- **Target:** `filesecurity.FileSecurity [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 33. propertylist

- **Target:** `propertylist.PropertyList [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 34. timezone

- **Target:** `timezone.Timezone [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 35. error

- **Target:** `error.Errors [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched (target 5)
- **Missing types:** _none_

### 36. string_tokenizer

- **Target:** `stringtokenizer.StringTokenizer [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 37. uuid

- **Target:** `uuid.Uuid [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 3)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 38. attributed_string

- **Target:** `attributedstring.AttributedString [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 310.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 39. lib

- **Target:** `corefoundationsys.Lib [ZERO] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 10.0
- **Functions:** 0/0 matched (target 10)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only by basename: `tests:tests/lib.rs` vs expected `lib.rs`
- **Proposed provenance header:** `// port-lint: tests lib.rs` (current: `// port-lint: tests tests/lib.rs`)
- **Lint issues:** 1

### 40. preferences

- **Target:** `preferences.Preferences`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 0.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/0 matched
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

