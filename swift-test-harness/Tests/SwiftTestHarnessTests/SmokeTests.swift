import XCTest
import CoreFoundationSysLibrary

final class SmokeTests: XCTestCase {
    /// Smoke-test that the Swift Export bridge can call into the
    /// Kotlin-facing CoreFoundation timezone surface and back.
    func testSystemTimeZoneRoundTrip() throws {
        CoreFoundationSys.cfTimeZoneResetSystem()
        let tz = CoreFoundationSys.cfTimeZoneCopySystem()
        XCTAssertNotNil(tz)
        defer { CoreFoundationSys.cfRelease(ref: tz!) }
        let name = CoreFoundationSys.cfTimeZoneGetName(tz: tz!)
        XCTAssertNotNil(name)
        let asString = CoreFoundationSys.cfStringGetCStringPtr(
            string: name!,
            encoding: CoreFoundationSys.CF_STRING_ENCODING_UTF8,
        )
        XCTAssertNotNil(asString)
        XCTAssertFalse(asString!.isEmpty)
    }
}
