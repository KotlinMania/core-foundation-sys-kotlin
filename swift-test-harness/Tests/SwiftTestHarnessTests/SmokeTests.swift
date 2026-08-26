#if canImport(Testing)
import Testing
import CoreFoundationSys

@Suite("CoreFoundationSys Swift Export Suite")
struct SmokeTests {
    @Test("System timezone round trip")
    func systemTimeZoneRoundTrip() {
        CoreFoundationSys.cfTimeZoneResetSystem()
        let tz = CoreFoundationSys.cfTimeZoneCopySystem()
        #expect(tz != nil)
        defer {
            if let tz = tz {
                CoreFoundationSys.cfRelease(ref: tz)
            }
        }
        let name = CoreFoundationSys.cfTimeZoneGetName(tz: tz!)
        #expect(name != nil)
        let asString = CoreFoundationSys.cfStringGetCStringPtr(
            string: name!,
            encoding: string.kCFStringEncodingUTF8
        )
        #expect(asString != nil)
        #expect(!asString!.isEmpty)
    }
}
#elseif canImport(XCTest)
import XCTest
import CoreFoundationSys

final class SmokeTests: XCTestCase {
    func testSystemTimeZoneRoundTrip() throws {
        CoreFoundationSys.cfTimeZoneResetSystem()
        let tz = CoreFoundationSys.cfTimeZoneCopySystem()
        XCTAssertNotNil(tz)
        defer { CoreFoundationSys.cfRelease(ref: tz!) }
        let name = CoreFoundationSys.cfTimeZoneGetName(tz: tz!)
        XCTAssertNotNil(name)
        let asString = CoreFoundationSys.cfStringGetCStringPtr(
            string: name!,
            encoding: string.kCFStringEncodingUTF8
        )
        XCTAssertNotNil(asString)
        XCTAssertFalse(asString!.isEmpty)
    }
}
#endif
