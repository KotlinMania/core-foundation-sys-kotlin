# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 10/40 (25.0%)
- **Function parity:** 1/13 matched (target 4) — 7.7%
- **Class/type parity:** 29/267 matched (target 37) — 10.9%
- **Combined symbol parity:** 30/280 matched (target 41) — 10.7%
- **Average inline-code cosine:** 0.30 (function body across 10 matched files)
- **Average documentation cosine:** 0.00 (doc text across 10 matched files)
- **Cheat-zeroed Files:** 7
- **Critical Issues:** 7 files with <0.60 function similarity

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
- **Priority Score:** 253910.0
- **Functions:** 1/4 matched (target 2)
- **Missing functions:** `from`, `as_void_ptr`, `from_void_ptr`
- **Types:** 13/35 matched (target 20)
- **Missing types:** `Boolean`, `CFAllocatorRef`, `CFNullRef`, `CFTypeRef`, `ConstStr255Param`, `StringPtr`, `ConstStringPtr`, `UInt8`, `UInt16`, `SInt16`, `SInt32`, `UInt32`, `CFComparatorFunction`, `CFAllocatorRetainCallBack`, `CFAllocatorReleaseCallBack`, `CFAllocatorCopyDescriptionCallBack`, `CFAllocatorAllocateCallBack`, `CFAllocatorReallocateCallBack`, `CFAllocatorDeallocateCallBack`, `CFAllocatorPreferredSizeCallBack`, `CFAllocatorContext`, `TCFTypeRef`

### 2. url

- **Target:** `url.Urls [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 50810.0
- **Functions:** 0/1 matched (target 0)
- **Missing functions:** `can_see_excluded_from_backup_key`
- **Types:** 3/7 matched (target 3)
- **Missing types:** `__CFURL`, `CFURLRef`, `CFURLBookmarkFileCreationOptions`, `CFURLComponentType`
- **Tests:** 0/1 matched

### 3. number

- **Target:** `number.Numbers [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 50610.0
- **Functions:** 0/1 matched (target 0)
- **Missing functions:** `match_for_type_id_should_be_backwards_compatible`
- **Types:** 1/5 matched (target 1)
- **Missing types:** `__CFBoolean`, `CFBooleanRef`, `__CFNumber`, `CFNumberRef`
- **Tests:** 0/1 matched

### 4. string

- **Target:** `string.Strings [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 30710.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 4/7 matched (target 4)
- **Missing types:** `__CFString`, `CFStringRef`, `CFMutableStringRef`

### 5. bit_vector

- **Target:** `bitvector.BitVector [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 30410.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 1/4 matched (target 1)
- **Missing types:** `__CFBitVector`, `CFBitVectorRef`, `CFMutableBitVectorRef`

### 6. data

- **Target:** `data.Data`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 30400.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 1/4 matched (target 1)
- **Missing types:** `__CFData`, `CFDataRef`, `CFMutableDataRef`

### 7. date

- **Target:** `date.Dates`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 20400.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 2/4 matched (target 2)
- **Missing types:** `__CFDate`, `CFDateRef`

### 8. uuid

- **Target:** `uuid.Uuid [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 20310.0
- **Functions:** 0/0 matched (target 2)
- **Missing functions:** _none_
- **Types:** 1/3 matched (target 1)
- **Missing types:** `__CFUUID`, `CFUUIDRef`

### 9. error

- **Target:** `error.Errors`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 20300.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 1/3 matched (target 2)
- **Missing types:** `__CFError`, `CFErrorRef`

### 10. propertylist

- **Target:** `propertylist.PropertyList [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 10310.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 2/3 matched (target 2)
- **Missing types:** `CFPropertyListRef`

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

